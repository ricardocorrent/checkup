package com.checkup.inspection;

import com.checkup.file.File;
import com.checkup.file.FileRepository;
import com.checkup.inspection.information.InspectionInformation;
import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.inspection.print.*;
import com.checkup.inspection.vo.*;
import com.checkup.item.Item;
import com.checkup.item.ItemRepository;
import com.checkup.item.information.ItemInformation;
import com.checkup.item.information.ItemInformationVO;
import com.checkup.rule.Rule;
import com.checkup.rule.RuleRepository;
import com.checkup.rule.RuleVO;
import com.checkup.rule.information.RuleInformation;
import com.checkup.rule.information.RuleInformationVO;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.model.BaseInformation;
import com.checkup.server.model.IdVO;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.target.Target;
import com.checkup.target.TargetDTO;
import com.checkup.target.TargetRepository;
import com.checkup.target.information.TargetInformation;
import com.checkup.target.information.TargetInformationVO;
import com.checkup.topic.Topic;
import com.checkup.topic.TopicRepository;
import com.checkup.user.User;
import com.checkup.user.UserRepository;
import com.checkup.user.UserVO;
import com.checkup.user.information.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;
    private final UserRepository userRepository;
    private final TargetRepository targetRepository;
    private final TopicRepository topicRepository;
    private final ItemRepository itemRepository;
    private final RuleRepository ruleRepository;
    private final FileRepository fileRepository;

    private InspectionValidator inspectionValidator;

    @Autowired
    public InspectionService(final InspectionRepository inspectionRepository,
                             final UserRepository userRepository,
                             final TargetRepository targetRepository,
                             final TopicRepository topicRepository,
                             final ItemRepository itemRepository,
                             final RuleRepository ruleRepository,
                             final FileRepository fileRepository) {
        this.inspectionRepository = inspectionRepository;
        this.userRepository = userRepository;
        this.targetRepository = targetRepository;
        this.topicRepository = topicRepository;
        this.itemRepository = itemRepository;
        this.ruleRepository = ruleRepository;
        this.fileRepository = fileRepository;
        inspectionValidator = new InspectionValidator();
    }

    @Override
    public Class<InspectionVO> getClazz() {
        return InspectionVO.class;
    }

    @Override
    public Class<Inspection> getEntityClazz() {
        return Inspection.class;
    }

    public InspectionCloseVO closeInspection(final IdVO idVO) {
        final Inspection inspection = inspectionRepository.findById(idVO.getId()).orElseThrow(RegisterNotFoundException::new);
        inspectionValidator.validateIfInspectionCanBeClosed(inspection);
        return handleCloseInspection(inspection);
    }

    private InspectionCloseVO handleCloseInspection(final Inspection inspection) {
        final Inspection clone = inspection.clone();
        targetRepository.save(clone.getTarget());
        inspectionRepository.save(clone);

        final Set<Topic> topicList = topicRepository.findByInspectionId(inspection.getId()).stream().map(Topic::clone).collect(Collectors.toSet());
        topicList.forEach(topic -> topic.setInspection(clone));

        final Set<Item> items = topicList.stream().map(Topic::getItem).collect(Collectors.toSet());

        final Map<Rule, Rule> oldRuleNewRule = new HashMap<>();
        final Set<Rule> rules = items.stream().map(Item::getRule).collect(Collectors.toSet());
        rules.forEach(rule -> {
            oldRuleNewRule.put(rule, rule.clone());
        });
        ruleRepository.saveAll(oldRuleNewRule.values());
        items.forEach(item -> {
            item.setRule(oldRuleNewRule.get(item.getRule()));
            itemRepository.save(item);
        });
        topicRepository.saveAll(topicList);

        return new InspectionCloseVO(clone.getId());
    }

    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }

    public List<InspectionInformation> getInspectionInformation(final UUID inspectionId) {
        return Optional.ofNullable(inspectionRepository.findById(inspectionId).get().getInformation())
                .orElseThrow(RegisterNotFoundException::new);
    }

    public InspectionCompleteVO getCompletedInspection(final UUID inspectionId) {
        final InspectionCompleteVO complete = new InspectionCompleteVO();

        final Optional<Inspection> inspectionFomDb = inspectionRepository.findById(inspectionId);
        inspectionFomDb.ifPresent(inspection -> {
            complete.setId(inspection.getId());
            complete.setTitle(inspection.getTitle());
            complete.setDescription(inspection.getDescription());
            complete.setDraft(inspection.getDraft());
            complete.setNote(inspection.getNote());
            complete.setInformation(DozerAdapter.parseListObjects(inspection.getInformation(), InspectionInformationVO.class));
            complete.setUser(DozerAdapter.parseObject(inspection.getUser(), UserVO.class));
            complete.setTarget(DozerAdapter.parseObject(inspection.getTarget(), TargetDTO.class));
        });

        final List<Topic> topics = topicRepository.findByInspectionId(inspectionId);
        topics.forEach(topic -> {
            final InspectionCompleteTopicVO topicVO = DozerAdapter.parseObject(topic, InspectionCompleteTopicVO.class);
            topicVO.setFiles(DozerAdapter.parseListObjects(fileRepository.findByTopicId(topic.getId()), InspectionCompleteFileVO.class));
            complete.getTopics().add(topicVO);
        });

        return complete;
    }

    public InspectionCompleteVO updateCompleteInspection(final InspectionCompleteVO entity) {
        handleInspection(entity);
        handleUser(entity.getUser());
        handleTarget(entity.getTarget());
        handleTopic(entity);
        return entity;
    }

    private void handleUser(final UserVO newUser) {
        final Optional<User> userFromDb = userRepository.findById(newUser.getId());
        userFromDb.ifPresent(user -> {
            user.getInformation().forEach(oi -> {
                newUser.getInformation().stream()
                        .filter(ni -> ni.getId().equals(oi.getId()))
                        .findFirst()
                        .ifPresent(ni -> oi.setActive(ni.getActive()));
            });
        });
        userRepository.save(userFromDb.get());
    }

    private void handleInspection(final InspectionCompleteVO entity) {
        final Inspection inspectionFromDb = inspectionRepository.getOne(entity.getId());
        inspectionFromDb.setTitle(entity.getTitle());
        inspectionFromDb.setDescription(entity.getDescription());
        inspectionFromDb.setNote(entity.getNote());
        handleInspectionInformation(inspectionFromDb.getInformation(), entity.getInformation());
        inspectionRepository.save(inspectionFromDb);
    }

    private void handleInspectionInformation(final List<InspectionInformation> oldInformation, final List<InspectionInformationVO> newInformation) {
        oldInformation.forEach(oi -> {
            newInformation.stream()
                    .filter(ni -> ni.getId().equals(oi.getId()))
                    .findFirst()
                    .ifPresent(ni -> oi.setActive(ni.getActive()));
        });
    }

    private void handleTarget(final TargetDTO targetDTO) {
        final Target targetFromDb = targetRepository.findById(targetDTO.getId()).get();
        handleTargetInformation(targetFromDb.getInformation(), targetDTO.getInformation());
        targetRepository.save(targetFromDb);
    }

    private void handleTargetInformation(final List<TargetInformation> oldInformation, final List<TargetInformationVO> newInformation) {
        oldInformation.forEach(oi -> {
            newInformation.stream()
                    .filter(ni -> ni.getId().equals(oi.getId()))
                    .findFirst()
                    .ifPresent(ni -> oi.setActive(ni.getActive()));
        });
    }

    private void handleTopic(final InspectionCompleteVO completeInspection) {
        final List<Topic> topicsFromDb = topicRepository.findByInspectionId(completeInspection.getId());

        topicsFromDb.forEach(topic -> {
            completeInspection.getTopics().stream()
                    .filter(topicsNew -> topicsNew.getId().equals(topic.getId()))
                    .findFirst()
                    .ifPresent(topicNew -> {
                        topic.setNote(topicNew.getNote());
                        topic.setPrintInReport(topicNew.getPrintInReport());
                        topic.setPositionIndex(topicNew.getPositionIndex());
                        handleItem(topic.getItem(), topicNew.getItem());
                        handleFile(topic, topicNew.getFiles());
                    });

        });

        topicRepository.saveAll(topicsFromDb);
    }

    private void handleItem(final Item oldItem, final InspectionCompleteItemVO newItem) {
        final Optional<Item> itemFromDb = itemRepository.findById(oldItem.getId());
        itemFromDb
                .ifPresent(item -> {
                    handleRule(item.getRule(), newItem.getRule());
                    handleItemInformation(item.getInformation(), newItem.getInformation());
                });

        itemRepository.save(itemFromDb.get());
    }

    private void handleRule(final Rule oldRule, final RuleVO newRule) {
        final Optional<Rule> ruleFromDb = ruleRepository.findById(oldRule.getId());
        ruleFromDb
                .ifPresent(rule -> {
                    handleRuleInformation(rule.getInformation(), newRule.getInformation());
                });
        ruleRepository.save(ruleFromDb.get());
    }

    private void handleRuleInformation(final List<RuleInformation> oldInformation, final List<RuleInformationVO> newInformation) {
        oldInformation.forEach(oi -> {
            newInformation.stream()
                    .filter(ni -> ni.getId().equals(oi.getId()))
                    .findFirst()
                    .ifPresent(ni -> oi.setActive(ni.getActive()));
        });
    }

    private void handleItemInformation(final List<ItemInformation> oldInformation, final List<ItemInformationVO> newInformation) {
        oldInformation.forEach(oi -> {
            newInformation.stream()
                    .filter(ni -> ni.getId().equals(oi.getId()))
                    .findFirst()
                    .ifPresent(ni -> oi.setActive(ni.getActive()));
        });
    }

    private void handleFile(final Topic topic, final List<InspectionCompleteFileVO> newFiles) {
        final List<File> filesFromDb = fileRepository.findByTopicId(topic.getId());

        filesFromDb.forEach(file -> {
            newFiles.stream()
                    .filter(nf -> nf.getId().equals(file.getId()) && nf.getActive())
                    .findFirst()
                    .ifPresentOrElse(nf -> file.setNote(nf.getNote()), () -> {
                        fileRepository.delete(file);
                    });
        });
        fileRepository.saveAll(filesFromDb);
    }

    public InspectionPrintDTO getPrintInspection(final UUID inspectionId) {
        final Optional<Inspection> completeInspection = inspectionRepository.findById(inspectionId);
        if (completeInspection.isPresent()) {
            return handlePrint(completeInspection.get());
        }
        throw new RegisterNotFoundException();
    }

    private InspectionPrintDTO handlePrint(final Inspection completeInspection) {
        final InspectionPrintDTO print = new InspectionPrintDTO();
        populateInspection(print, completeInspection);
        populateTarget(print, completeInspection);
        populateRule(print, completeInspection);
        populateUser(print, completeInspection);
        return print;
    }

    private void populateInspection(final InspectionPrintDTO print, final Inspection completeInspection) {
        print.setId(completeInspection.getId());
        print.setTitle(completeInspection.getTitle());
        print.setDescription(completeInspection.getDescription());
        print.setDraft(completeInspection.getDraft());
        print.setNote(completeInspection.getNote());

        final List<InspectionInformation> inspectionInformation =
                completeInspection.getInformation().stream()
                        .filter(InspectionInformation::getActive)
                        .collect(Collectors.toList());

        print.setInformation(DozerAdapter.parseListObjects(inspectionInformation, InspectionPrintInformationDTO.class));
    }

    private void populateTarget(final InspectionPrintDTO print, final Inspection completeInspection) {
        final List<TargetInformation> targetInformation =
                completeInspection.getTarget().getInformation().stream()
                .filter(BaseInformation::getActive)
                .collect(Collectors.toList());

        final List<InspectionPrintTargetInformationDTO> targetInformationDTO =
                DozerAdapter.parseListObjects(targetInformation, InspectionPrintTargetInformationDTO.class);

        final InspectionPrintTargetDTO inspectionPrintTargetDTO =
                DozerAdapter.parseObject(completeInspection.getTarget(), InspectionPrintTargetDTO.class);

        inspectionPrintTargetDTO.setInformation(targetInformationDTO);
        print.setTarget(inspectionPrintTargetDTO);
    }

    private void populateRule(final InspectionPrintDTO print, final Inspection completeInspection) {

        final Map<UUID, Set<UUID>> cache = new HashMap<>();
        final List<InspectionPrintRuleDTO> ruleDTOList = new ArrayList<>();

        final List<Topic> topics =
                topicRepository.findByInspectionId(completeInspection.getId())
                        .stream()
                        .filter(Topic::getPrintInReport)
                        .collect(Collectors.toList());

        topics.forEach(topic -> {
            final UUID ruleId = topic.getItem().getRule().getId();
            final UUID itemId = topic.getItem().getId();
            final InspectionPrintRuleDTO inspectionPrintRuleDTO = DozerAdapter.parseObject(topic.getItem().getRule(), InspectionPrintRuleDTO.class);
            final InspectionPrintRuleItemDTO inspectionPrintRuleItemDTO = DozerAdapter.parseObject(topic.getItem(), InspectionPrintRuleItemDTO.class);

            inspectionPrintRuleItemDTO.setNote(topic.getNote());

            final List<File> filesList = fileRepository.findByTopicId(topic.getId());
            if (!CollectionUtils.isEmpty(filesList)) {
                inspectionPrintRuleItemDTO.setFiles(DozerAdapter.parseListObjects(filesList, InspectionPrintFileDTO.class));
            }

            if (cache.containsKey(ruleId)) {
                if (!cache.get(ruleId).contains(itemId)) {
                    ruleDTOList.forEach(iprdto -> {
                        if (iprdto.getId().equals(inspectionPrintRuleDTO.getId())) {
                            iprdto.getItems().add(inspectionPrintRuleItemDTO);
                        }
                    });
                    cache.get(ruleId).add(itemId);
                }
            } else {
                cache.put(ruleId, Stream.of(itemId).collect(Collectors.toSet()));
                inspectionPrintRuleDTO.setItems(Stream.of(inspectionPrintRuleItemDTO).collect(Collectors.toList()));
                ruleDTOList.add(inspectionPrintRuleDTO);
            }
        });


        print.setRules(ruleDTOList);
    }

    private void populateUser(final InspectionPrintDTO print, final Inspection completeInspection) {
        final List<UserInformation> userInformation = completeInspection.getUser().getInformation().stream()
                .filter(BaseInformation::getActive)
                .collect(Collectors.toList());

        final List<InspectionPrintUserInformationDTO> inspectionPrintUserInformationDTO =
                DozerAdapter.parseListObjects(userInformation, InspectionPrintUserInformationDTO.class);

        final InspectionPrintUserVO inspectionPrintUserVO =
                DozerAdapter.parseObject(completeInspection.getUser(), InspectionPrintUserVO.class);

        inspectionPrintUserVO.setInformation(inspectionPrintUserInformationDTO);
        print.setUser(inspectionPrintUserVO);
    }

}

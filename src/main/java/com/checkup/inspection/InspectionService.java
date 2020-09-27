package com.checkup.inspection;

import com.checkup.file.File;
import com.checkup.file.FileRepository;
import com.checkup.inspection.information.InspectionInformation;
import com.checkup.inspection.vo.InspectionCloseVO;
import com.checkup.inspection.vo.InspectionCompleteVO;
import com.checkup.item.Item;
import com.checkup.item.ItemRepository;
import com.checkup.rule.Rule;
import com.checkup.rule.RuleRepository;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.model.IdVO;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.target.TargetRepository;
import com.checkup.topic.Topic;
import com.checkup.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;
    private final TargetRepository targetRepository;
    private final TopicRepository topicRepository;
    private final ItemRepository itemRepository;
    private final RuleRepository ruleRepository;
    private final FileRepository fileRepository;

    private InspectionValidator inspectionValidator;

    @Autowired
    public InspectionService(final InspectionRepository inspectionRepository,
                             final TargetRepository targetRepository,
                             final TopicRepository topicRepository,
                             final ItemRepository itemRepository,
                             final RuleRepository ruleRepository,
                             final FileRepository fileRepository) {
        this.inspectionRepository = inspectionRepository;
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
        final Optional<Inspection> inspection = inspectionRepository.findById(inspectionId);
        final List<Topic> topics = topicRepository.findByInspectionId(inspectionId);
        final List<File> files = fileRepository.findAll();
        topics.forEach(topic -> {
            files.forEach(file -> {
                if (topic.getId().equals(file.getTopic().getId())) {
                    topic.getFiles().add(file);
                }
            });
        });
        inspection.get().setTopics(topics);
        return DozerAdapter.parseObject(inspection.get(), InspectionCompleteVO.class);
    }
}

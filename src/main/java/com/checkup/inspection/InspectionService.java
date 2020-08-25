package com.checkup.inspection;

import com.checkup.inspection.vo.InspectionFinalizeVO;
import com.checkup.item.ItemRepository;
import com.checkup.rule.RuleRepository;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.model.IdVO;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.target.TargetRepository;
import com.checkup.topic.Topic;
import com.checkup.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;
    private final TargetRepository targetRepository;
    private final TopicRepository topicRepository;
    private final ItemRepository itemRepository;
    private final RuleRepository ruleRepository;

    private InspectionValidator inspectionValidator;

    @Autowired
    public InspectionService(final InspectionRepository inspectionRepository,
                             final TargetRepository targetRepository,
                             final TopicRepository topicRepository,
                             final ItemRepository itemRepository,
                             final RuleRepository ruleRepository) {
        this.inspectionRepository = inspectionRepository;
        this.targetRepository = targetRepository;
        this.topicRepository = topicRepository;
        this.itemRepository = itemRepository;
        this.ruleRepository = ruleRepository;
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

    public InspectionFinalizeVO closeInspection(final IdVO idVO) {
        final Inspection inspection = inspectionRepository.findById(idVO.getId()).orElseThrow(RegisterNotFoundException::new);
        inspectionValidator.validateIfInspectionCanBeClosed(inspection);
        return handleCloseInspection(inspection);
    }

    private InspectionFinalizeVO handleCloseInspection(final Inspection inspection) {
        final Inspection clone = inspection.clone();
        topicRepository.findByInspectionId(inspection.getId()).stream().map(Topic::clone).collect(Collectors.toList());
        targetRepository.save(clone.getTarget());
        inspectionRepository.save(clone);
        return new InspectionFinalizeVO(clone.getId());
    }
}

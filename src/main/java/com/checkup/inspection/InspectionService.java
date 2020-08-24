package com.checkup.inspection;

import com.checkup.inspection.vo.InspectionFinalizeVO;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.model.BaseModel;
import com.checkup.server.model.IdVO;
import com.checkup.server.model.PrototypePattern;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.target.Target;
import com.checkup.target.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;
    private final TargetRepository targetRepository;

    private InspectionValidator inspectionValidator;

    @Autowired
    public InspectionService(final InspectionRepository inspectionRepository,
                             final TargetRepository targetRepository) {
        this.inspectionRepository = inspectionRepository;
        this.targetRepository = targetRepository;
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
        inspection.setDraft(Boolean.FALSE);
        return handleCloseInspection(inspection);
    }

    private InspectionFinalizeVO handleCloseInspection(final Inspection inspection) {
        final Inspection clone = (Inspection) inspection.clone();
        final Target target = targetRepository.save((Target) inspection.getTarget().clone());

        clone.setTarget(target);
        inspectionRepository.save(clone);
        return new InspectionFinalizeVO(clone.getId());
    }
}

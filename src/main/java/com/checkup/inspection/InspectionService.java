package com.checkup.inspection;

import com.checkup.inspection.vo.InspectionFinalizeVO;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.model.BaseModel;
import com.checkup.server.model.IdVO;
import com.checkup.server.model.PrototypePattern;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;

    private InspectionValidator inspectionValidator;

    @Autowired
    public InspectionService(final InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
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
        System.out.println(clone.getTitle());
        return null;
    }
}

package com.checkup.inspection;

import com.checkup.server.SimpleAbstractService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    private final InspectionRepository inspectionRepository;

    @Inject
    public InspectionService(final InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public Class<InspectionVO> getClazz() {
        return InspectionVO.class;
    }

    @Override
    public Class<Inspection> getEntityClazz() {
        return Inspection.class;
    }
}

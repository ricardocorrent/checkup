package com.checkup.inspection;

import com.checkup.server.SimpleAbstractService;
import org.springframework.stereotype.Service;

@Service
public class InspectionService extends SimpleAbstractService<Inspection, InspectionVO> {

    @Override
    public Class<InspectionVO> getClazz() {
        return InspectionVO.class;
    }

    @Override
    public Class<Inspection> getEntityClazz() {
        return Inspection.class;
    }
}

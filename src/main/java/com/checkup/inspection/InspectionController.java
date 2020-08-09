package com.checkup.inspection;

import com.checkup.server.SimpleAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/inspection")
public class InspectionController extends SimpleAbstractController<Inspection, InspectionVO> {

    private final InspectionService inspectionService;

    @Inject
    public InspectionController(final InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @Override
    protected String getListAllSortProperty() {
        return "title";
    }
}

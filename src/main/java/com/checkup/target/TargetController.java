package com.checkup.target;

import com.checkup.server.SimpleAbstractController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/target")
public class TargetController extends SimpleAbstractController<Target, TargetDTO> {

    private final TargetService targetService;

    @Inject
    public TargetController(final TargetService targetService) {
        this.targetService = targetService;
    }

    @Override
    protected String getListAllSortProperty() {
        return "name";
    }
}

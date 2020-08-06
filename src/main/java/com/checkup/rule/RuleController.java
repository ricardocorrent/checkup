package com.checkup.rule;

import com.checkup.server.SimpleAbstractController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/rule")
public class RuleController extends SimpleAbstractController<Rule, RuleVO> {

    private final RuleService ruleService;

    @Inject
    public RuleController(final RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    protected String getListAllSortProperty() {
        return "title";
    }
}

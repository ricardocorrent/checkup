package com.checkup.rule;

import com.checkup.server.SimpleAbstractService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RuleService extends SimpleAbstractService<Rule, RuleVO> {

    private final RuleRepository ruleRepository;

    @Inject
    public RuleService(final RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public Class<RuleVO> getClazz() {
        return RuleVO.class;
    }

    @Override
    public Class<Rule> getEntityClazz() {
        return Rule.class;
    }
}

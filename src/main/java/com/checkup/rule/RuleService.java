package com.checkup.rule;

import com.checkup.item.Item;
import com.checkup.item.ItemRepository;
import com.checkup.server.SimpleAbstractService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class RuleService extends SimpleAbstractService<Rule, RuleVO> {

    private final RuleRepository ruleRepository;
    private final ItemRepository itemRepository;

    @Inject
    public RuleService(final RuleRepository ruleRepository,
                       final ItemRepository itemRepository) {
        this.ruleRepository = ruleRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Class<RuleVO> getClazz() {
        return RuleVO.class;
    }

    @Override
    public Class<Rule> getEntityClazz() {
        return Rule.class;
    }

    public List<Item> getItemFromRule(final UUID ruleId) {
        return itemRepository.findByRuleId(ruleId);
    }
}

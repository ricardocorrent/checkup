package com.checkup.item;

import com.checkup.item.vo.ItemsByRuleIdResponseVO;
import com.checkup.rule.Rule;
import com.checkup.rule.RuleRepository;
import com.checkup.rule.information.RuleInformationVO;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService extends SimpleAbstractService<Item, ItemVO> {

    private final ItemRepository itemRepository;
    private final RuleRepository ruleRepository;

    @Inject
    public ItemService(final ItemRepository itemRepository,
                       final RuleRepository ruleRepository) {
        this.itemRepository = itemRepository;
        this.ruleRepository = ruleRepository;
    }

    public ItemsByRuleIdResponseVO getItemsByRuleId(final UUID ruleId) {
        final Rule rule = ruleRepository.findById(ruleId).orElseThrow(RegisterNotFoundException::new);

        return createResponseToSendItemsByRuleId(itemRepository.findByRuleId(rule.getId()), rule);
    }

    private ItemsByRuleIdResponseVO createResponseToSendItemsByRuleId(final List<Item> byRuleId, final Rule rule) {
        final ItemsByRuleIdResponseVO response = new ItemsByRuleIdResponseVO();
        response.setId(rule.getId());
        response.setTitle(rule.getTitle());
        response.setDescription(rule.getDescription());
        response.setInformation(DozerAdapter.parseListObjects(rule.getInformation(), RuleInformationVO.class));
        response.setItems(DozerAdapter.parseListObjects(byRuleId, ItemVO.class));
        return response;
    }

    @Override
    public Class<ItemVO> getClazz() {
        return ItemVO.class;
    }


    @Override
    public Class<Item> getEntityClazz() {
        return Item.class;
    }
}

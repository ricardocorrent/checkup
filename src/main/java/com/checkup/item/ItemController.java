package com.checkup.item;

import com.checkup.server.SimpleAbstractController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/item")
public class ItemController extends SimpleAbstractController<Item, ItemVO> {

    private ItemService itemService;

    @Inject
    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/items/{ruleId}")
    public ResponseEntity<?> getItemsListFromRuleId(@PathVariable("ruleId") final UUID ruleId) {
        return ResponseEntity.ok(itemService.getItemsByRuleId(ruleId));
    }

    @Override
    public ResponseEntity<?> listAll(int page, int limit, String direction, PagedResourcesAssembler<ItemVO> assembler) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    protected String getListAllSortProperty() {
        return "title";
    }
}

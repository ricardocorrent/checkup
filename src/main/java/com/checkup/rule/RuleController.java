package com.checkup.rule;

import com.checkup.item.ItemVO;
import com.checkup.rule.vo.ItemsResponseVO;
import com.checkup.server.SimpleAbstractController;
import com.checkup.server.adapter.DozerAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

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
        return "information.positionIndex";
    }

    @GetMapping(path = "/{id}/items")
    public ResponseEntity<?> getRuleItems(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DozerAdapter.parseListObjects(ruleService.getItemFromRule(id), ItemsResponseVO.class));
    }
}

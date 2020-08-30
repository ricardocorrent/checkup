package com.checkup.inspection.vo;

import com.checkup.item.information.ItemInformationVO;
import com.checkup.rule.RuleVO;
import com.checkup.server.model.BaseVO;
import com.checkup.topic.vo.TopicRuleVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * VO that represent ITEM
 */
@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "information", "createdAt", "updatedAt"})
public class InspectionCompleteItemVO extends BaseVO {

    private String title;

    private String description;

    private Integer positionIndex;

    private Boolean active = Boolean.TRUE;

    private List<ItemInformationVO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private RuleVO rule;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ItemInformationVO> getInformation() {
        return information;
    }

    public void setInformation(List<ItemInformationVO> information) {
        this.information = information;
    }

    public RuleVO getRule() {
        return rule;
    }

    public void setRule(RuleVO rule) {
        this.rule = rule;
    }
}

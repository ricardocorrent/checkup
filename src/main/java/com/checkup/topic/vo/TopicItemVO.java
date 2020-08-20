package com.checkup.topic.vo;

import com.checkup.item.information.ItemInformationVO;
import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "information", "createdAt", "updatedAt"})
public class TopicItemVO extends BaseVO {

    private String title;

    private String description;

    private Integer positionIndex;

    private Boolean active = Boolean.TRUE;

    private List<ItemInformationVO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private TopicRuleVO rule;

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

    public TopicRuleVO getRule() {
        return rule;
    }

    public void setRule(TopicRuleVO rule) {
        this.rule = rule;
    }
}

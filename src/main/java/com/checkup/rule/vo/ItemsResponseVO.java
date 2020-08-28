package com.checkup.rule.vo;

import com.checkup.rule.information.RuleInformationVO;
import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "active", "information"})
public class ItemsResponseVO extends BaseVO {

    private String title;

    private String description;

    private Boolean active;

    private List<RuleInformationVO> information;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<RuleInformationVO> getInformation() {
        return information;
    }

    public void setInformation(List<RuleInformationVO> information) {
        this.information = information;
    }

}

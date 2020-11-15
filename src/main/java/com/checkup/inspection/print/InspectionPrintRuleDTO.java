package com.checkup.inspection.print;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "information"})
public class InspectionPrintRuleDTO extends BaseVO {

    private String title;

    private String description;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintRuleInformationDTO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintRuleItemDTO> items;

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

    public List<InspectionPrintRuleInformationDTO> getInformation() {
        return information;
    }

    public void setInformation(List<InspectionPrintRuleInformationDTO> information) {
        this.information = information;
    }

    public List<InspectionPrintRuleItemDTO> getItems() {
        return items;
    }

    public void setItems(List<InspectionPrintRuleItemDTO> items) {
        this.items = items;
    }
}

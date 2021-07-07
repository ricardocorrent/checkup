package com.checkup.inspection.print;

import com.checkup.item.information.ItemInformationVO;
import com.checkup.rule.RuleVO;
import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "note", "information"})
public class InspectionPrintRuleItemDTO extends BaseVO {

    private String title;

    private String description;

    private Integer positionIndex;

    private Boolean active;

    private String note;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintItemInformationDTO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintFileDTO> files;

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

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public List<InspectionPrintItemInformationDTO> getInformation() {
        return information;
    }

    public void setInformation(List<InspectionPrintItemInformationDTO> information) {
        this.information = information;
    }

    public List<InspectionPrintFileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<InspectionPrintFileDTO> files) {
        this.files = files;
    }
}

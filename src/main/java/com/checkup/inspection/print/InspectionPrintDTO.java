package com.checkup.inspection.print;

import com.checkup.server.model.BaseVO;
import com.checkup.target.TargetDTO;
import com.checkup.user.UserVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "draft", "note", "information", "target", "rules", "user"})
public class InspectionPrintDTO extends BaseVO {

    private String title;

    private String description;

    private Boolean draft;

    private String note;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintInformationDTO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private InspectionPrintTargetDTO target;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintRuleDTO> rules;

    @JsonIgnoreProperties({"userName", "createdAt", "updatedAt"})
    private InspectionPrintUserVO user;

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

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<InspectionPrintInformationDTO> getInformation() {
        return information;
    }

    public void setInformation(List<InspectionPrintInformationDTO> information) {
        this.information = information;
    }

    public InspectionPrintTargetDTO getTarget() {
        return target;
    }

    public void setTarget(InspectionPrintTargetDTO target) {
        this.target = target;
    }

    public InspectionPrintUserVO getUser() {
        return user;
    }

    public void setUser(final InspectionPrintUserVO user) {
        this.user = user;
    }

    public List<InspectionPrintRuleDTO> getRules() {
        return rules;
    }

    public void setRules(List<InspectionPrintRuleDTO> rules) {
        this.rules = rules;
    }
}

package com.checkup.rule;

import com.checkup.rule.information.RuleInformation;
import com.checkup.rule.information.RuleInformationVO;
import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "active", "information", "createdAt", "updatedAt"})
public class RuleVO extends BaseVO {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String title;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 4000)
    private String description;

    @NotNull
    private Boolean active = Boolean.TRUE;

    private List<RuleInformationVO> information;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public List<RuleInformationVO> getInformation() {
        return information;
    }

    public void setInformation(final List<RuleInformationVO> information) {
        this.information = information;
    }
}

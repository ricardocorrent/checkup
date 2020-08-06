package com.checkup.rule;

import com.checkup.rule.information.RuleInformation;
import com.checkup.server.model.PhysicalBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "rule", schema = "checkup")
public class Rule extends PhysicalBaseEntity {

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rule_id", nullable = false)
    private List<RuleInformation> information;

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

    public List<RuleInformation> getInformation() {
        return information;
    }

    public void setInformation(final List<RuleInformation> information) {
        this.information = information;
    }
}

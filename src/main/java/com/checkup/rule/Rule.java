package com.checkup.rule;

import com.checkup.rule.information.RuleInformation;
import com.checkup.server.model.PrototypePhysicalBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "rule", schema = "checkup")
public class Rule extends PrototypePhysicalBaseEntity {

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

    @Column(updatable = false)
    private Boolean cloned = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rule_id", nullable = false)
    private List<RuleInformation> information;

    public Rule() {
    }

    public Rule(final Rule rule) {
        super(rule);
        if (rule != null) {
            this.title = rule.title;
            this.description = rule.description;
            this.active = rule.active;
            this.cloned = Boolean.TRUE;
            this.information =
                    rule.information
                            .stream()
                            .map(RuleInformation::clone)
                            .collect(Collectors.toList());
        }
    }

    @Override
    public Rule clone() {
        return new Rule(this);
    }

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

    public Boolean getCloned() {
        return cloned;
    }

    public void setCloned(final Boolean cloned) {
        this.cloned = cloned;
    }

    public List<RuleInformation> getInformation() {
        return information;
    }

    public void setInformation(final List<RuleInformation> information) {
        this.information = information;
    }
}

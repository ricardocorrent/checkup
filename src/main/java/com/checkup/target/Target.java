package com.checkup.target;

import com.checkup.server.model.PhysicalBaseEntity;
import com.checkup.server.model.PrototypePattern;
import com.checkup.target.information.TargetInformation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "target", schema = "checkup")
public class Target extends PrototypePattern {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private Boolean active = Boolean.TRUE;

    private Boolean cloned = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "target_id", nullable = false)
    private List<TargetInformation> information;

    public Target() {
    }

    public Target(final Target target) {
        super(target);
        if (target != null) {
            this.name = target.name;
            this.active = target.active;
            this.information = target.information.stream().map(targetInformation -> (TargetInformation) targetInformation.clone()).collect(Collectors.toList());
        }
    }

    @Override
    public PrototypePattern clone() {
        return new Target(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCloned() {
        return cloned;
    }

    public void setCloned(final Boolean cloned) {
        this.cloned = cloned;
    }

    public List<TargetInformation> getInformation() {
        return information;
    }

    public void setInformation(List<TargetInformation> information) {
        this.information = information;
    }
}

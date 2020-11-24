package com.checkup.target;

import com.checkup.server.model.PrototypePhysicalBaseEntity;
import com.checkup.target.information.TargetInformation;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "target", schema = "checkup")
public class Target extends PrototypePhysicalBaseEntity {

    private String name;

    private Boolean active = Boolean.TRUE;

    @Column(updatable = false)
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
            this.cloned = Boolean.TRUE;
            this.information =
                    target.information
                            .stream()
                            .map(TargetInformation::clone)
                            .collect(Collectors.toList());
        }
    }

    @Override
    public Target clone() {
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

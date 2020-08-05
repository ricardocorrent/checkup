package com.checkup.target;

import com.checkup.server.model.PhysicalBaseEntity;
import com.checkup.target.information.TargetInformation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "target", schema = "checkup")
public class Target extends PhysicalBaseEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private Boolean active = Boolean.TRUE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "target_id", nullable = false)
    private List<TargetInformation> information;

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

    public List<TargetInformation> getInformation() {
        return information;
    }

    public void setInformation(List<TargetInformation> information) {
        this.information = information;
    }
}

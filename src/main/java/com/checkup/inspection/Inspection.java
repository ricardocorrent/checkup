package com.checkup.inspection;

import com.checkup.inspection.information.InspectionInformation;
import com.checkup.server.model.PrototypePhysicalBaseEntity;
import com.checkup.target.Target;
import com.checkup.topic.Topic;
import com.checkup.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "inspection", schema = "checkup")
public class Inspection extends PrototypePhysicalBaseEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String description;

    @NotNull
    private Boolean draft = Boolean.TRUE;

    private Integer syncQuantities;

    @Size(max = 4000)
    private String note;

    private Boolean allowedToSync = Boolean.FALSE;

    @Column(updatable = false)
    private Boolean cloned = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "inspection_id", nullable = false)
    private List<InspectionInformation> information;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "target_id")
    private Target target;

    @JsonIgnore
    @OneToMany
    private List<Topic> topics;

    public Inspection() {
    }

    public Inspection(final Inspection inspection) {
        super(inspection);
        if (inspection != null) {
            this.title = inspection.title;
            this.description = inspection.description;
            this.draft = Boolean.FALSE;
            this.syncQuantities = inspection.syncQuantities;
            this.note = inspection.note;
            this.allowedToSync = inspection.allowedToSync;
            this.cloned = Boolean.TRUE;
            this.information =
                    inspection.information
                            .stream()
                            .map(InspectionInformation::clone)
                            .collect(Collectors.toList());
            this.user = inspection.user;
            this.target = inspection.target.clone();
        }
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

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(final Boolean draft) {
        this.draft = draft;
    }

    public Integer getSyncQuantities() {
        return syncQuantities;
    }

    public void setSyncQuantities(final Integer syncQuantities) {
        this.syncQuantities = syncQuantities;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public Boolean getAllowedToSync() {
        return allowedToSync;
    }

    public void setAllowedToSync(final Boolean allowedToSync) {
        this.allowedToSync = allowedToSync;
    }

    public Boolean getCloned() {
        return cloned;
    }

    public void setCloned(final Boolean cloned) {
        this.cloned = cloned;
    }

    public List<InspectionInformation> getInformation() {
        return information;
    }

    public void setInformation(final List<InspectionInformation> information) {
        this.information = information;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(final Target target) {
        this.target = target;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(final List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public Inspection clone() {
        return new Inspection(this);
    }
}

package com.checkup.topic;

import com.checkup.file.File;
import com.checkup.inspection.Inspection;
import com.checkup.item.Item;
import com.checkup.server.model.PhysicalBaseEntity;
import com.checkup.server.model.PrototypePhysicalBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "topic", schema = "checkup")
public class Topic extends PrototypePhysicalBaseEntity {

    @ManyToOne
    @JoinColumn(name = "inspection_id", nullable = false)
    private Inspection inspection;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @NotNull
    private Boolean printInReport;

    @Column(updatable = false)
    private Boolean cloned = Boolean.FALSE;

    @NotNull
    private Integer positionIndex;

    @Size(max = 4000)
    private String note;

    @JsonIgnore
    @OneToMany
    private List<File> files;

    public Topic() {
    }

    public Topic(final Topic topic) {
        super(topic);
        this.item = topic.item.clone();
        this.printInReport = topic.printInReport;
        this.cloned = Boolean.TRUE;
        this.positionIndex = topic.positionIndex;
        this.note = topic.note;
    }

    @Override
    public Topic clone() {
        return new Topic(this);
    }

    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(final Inspection inspection) {
        this.inspection = inspection;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public Boolean getPrintInReport() {
        return printInReport;
    }

    public void setPrintInReport(final Boolean printInReport) {
        this.printInReport = printInReport;
    }

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(final Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public Boolean getCloned() {
        return cloned;
    }

    public void setCloned(final Boolean cloned) {
        this.cloned = cloned;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(final List<File> files) {
        this.files = files;
    }
}

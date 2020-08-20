package com.checkup.topic;

import com.checkup.inspection.Inspection;
import com.checkup.item.Item;
import com.checkup.server.model.PhysicalBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "topic", schema = "checkup")
public class Topic extends PhysicalBaseEntity {

    @ManyToOne
    @JoinColumn(name = "inspection_id", nullable = false)
    private Inspection inspection;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private Boolean printInReport;

    private Integer positionIndex;

    @Size(max = 4000)
    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }
}

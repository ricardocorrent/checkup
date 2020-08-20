package com.checkup.topic.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "inspection", "item", "printInReport", "positionIndex", "active", "createdAt", "updatedAt"})
public class TopicVO extends BaseVO {

    private TopicInspectionVO inspection;

    private TopicItemVO item;

    private Boolean printInReport;

    private Integer positionIndex;

    private String note;

    public TopicInspectionVO getInspection() {
        return inspection;
    }

    public void setInspection(final TopicInspectionVO inspection) {
        this.inspection = inspection;
    }

    public TopicItemVO getItem() {
        return item;
    }

    public void setItem(final TopicItemVO item) {
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

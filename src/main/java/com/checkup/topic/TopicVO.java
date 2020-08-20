package com.checkup.topic;

import com.checkup.server.model.BaseVO;
import com.checkup.topic.vo.TopicInspectionVO;
import com.checkup.topic.vo.TopicItemVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@JsonPropertyOrder({"id", "inspection", "printInReport", "positionIndex", "item", "note"})
public class TopicVO extends BaseVO {

    @NotNull
    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private TopicInspectionVO inspection;

    @NotNull
    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private TopicItemVO item;

    @NotNull
    private Boolean printInReport;

    @NotNull
    private Integer positionIndex;

    @Size(max = 4000)
    private String note;

    public TopicInspectionVO getInspection() {
        return inspection;
    }

    public void setInspection(TopicInspectionVO inspection) {
        this.inspection = inspection;
    }

    public TopicItemVO getItem() {
        return item;
    }

    public void setItem(TopicItemVO item) {
        this.item = item;
    }

    public Boolean getPrintInReport() {
        return printInReport;
    }

    public void setPrintInReport(Boolean printInReport) {
        this.printInReport = printInReport;
    }

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

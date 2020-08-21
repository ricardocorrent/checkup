package com.checkup.topic.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "printInReport", "positionIndex", "note", "item"})
public class TopicsByInspectionIdResponseTopicVO extends BaseVO {

    private String title;

    private String description;

    private Boolean printInReport;

    private Integer positionIndex;

    private String note;

    private TopicItemVO item;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public TopicItemVO getItem() {
        return item;
    }

    public void setItem(TopicItemVO item) {
        this.item = item;
    }
}

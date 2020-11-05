package com.checkup.inspection.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * VO that represent a complete TOPIC
 */
@JsonPropertyOrder({"id", "title", "description", "printInReport", "positionIndex", "note", "item", "files", "createdAt", "updatedAt"})
public class InspectionCompleteTopicVO extends BaseVO {

    private String title;

    private String description;

    private Boolean printInReport;

    private Integer positionIndex;

    private String note;

    private InspectionCompleteItemVO item;

    private List<InspectionCompleteFileVO> files;

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

    public InspectionCompleteItemVO getItem() {
        return item;
    }

    public void setItem(final InspectionCompleteItemVO item) {
        this.item = item;
    }

    public List<InspectionCompleteFileVO> getFiles() {
        return files;
    }

    public void setFiles(final List<InspectionCompleteFileVO> files) {
        this.files = files;
    }
}

package com.checkup.inspection.print;

import com.checkup.attachment.vo.AttachmentVO;
import com.checkup.file.vo.FileTopicVO;
import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonPropertyOrder({"id", "positionIndex", "active", "note", "attachment"})
public class InspectionPrintFileDTO extends BaseVO {

    private Integer positionIndex;

    private Boolean active;

    private String note;

    private AttachmentVO attachment;

    private FileTopicVO topic;

    private String link;

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(final Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public AttachmentVO getAttachment() {
        return attachment;
    }

    public void setAttachment(final AttachmentVO attachment) {
        this.attachment = attachment;
    }

    public FileTopicVO getTopic() {
        return topic;
    }

    public void setTopic(final FileTopicVO topic) {
        this.topic = topic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }
}

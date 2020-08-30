package com.checkup.file.vo;

import com.checkup.attachment.vo.AttachmentVO;
import com.checkup.rule.RuleVO;
import com.checkup.server.model.BaseVO;
import com.checkup.topic.vo.TopicVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonPropertyOrder({"id", "positionIndex", "active", "note", "attachment", "createdAt", "updatedAt"})
public class FileVO extends BaseVO {

    @NotNull
    private Integer positionIndex;

    @NotNull
    private Boolean active = Boolean.TRUE;

    @Size(max = 4000)
    private String note;

    private AttachmentVO attachment;

    private FileTopicVO topic;

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
}

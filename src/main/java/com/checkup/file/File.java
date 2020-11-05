package com.checkup.file;

import com.checkup.attachment.Attachment;
import com.checkup.server.model.PhysicalBaseEntity;
import com.checkup.topic.Topic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "file", schema = "checkup")
public class File extends PhysicalBaseEntity {

    @NotNull
    private Integer positionIndex;

    @NotNull
    private Boolean active = Boolean.TRUE;

    @Size(max = 4000)
    private String note;

    @OneToOne
    @JoinColumn(name = "attachment_id", nullable = false)
    private Attachment attachment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

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

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(final Attachment attachment) {
        this.attachment = attachment;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(final Topic topic) {
        this.topic = topic;
    }
}

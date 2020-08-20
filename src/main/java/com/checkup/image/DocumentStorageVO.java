package com.checkup.image;

import com.checkup.server.model.BaseVO;

import java.util.UUID;

public class DocumentStorageVO extends BaseVO {

    private UUID topicId;

    private Integer positionIndex;

    private String note;

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(final UUID topicId) {
        this.topicId = topicId;
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

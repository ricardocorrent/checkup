package com.checkup.topic.vo;

import java.io.Serializable;
import java.util.UUID;

public class TopicItemVO implements Serializable {

    private UUID id;

    private String title;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }
}

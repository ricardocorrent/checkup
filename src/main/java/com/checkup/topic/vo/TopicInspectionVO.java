package com.checkup.topic.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VO that represent INSPECTION
 */
@JsonPropertyOrder({"id", "title", "description",})
public class TopicInspectionVO extends BaseVO {

    private String title;

    private String description;

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
}

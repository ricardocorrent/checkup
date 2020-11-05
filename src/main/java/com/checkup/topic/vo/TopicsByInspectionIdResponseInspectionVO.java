package com.checkup.topic.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "topics"})
public class TopicsByInspectionIdResponseInspectionVO extends BaseVO {

    private String title;

    private String description;

    @JsonIgnoreProperties({"inspection"})
    private List<TopicsByInspectionIdResponseTopicVO> topics;

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

    public List<TopicsByInspectionIdResponseTopicVO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsByInspectionIdResponseTopicVO> topics) {
        this.topics = topics;
    }
}

package com.checkup.topic.vo;

import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.server.model.BaseVO;
import com.checkup.target.TargetVO;
import com.checkup.user.UserVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "title", "description", })
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

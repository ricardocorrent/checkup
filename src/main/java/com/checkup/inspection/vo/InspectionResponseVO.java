package com.checkup.inspection.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "draft"})
public class InspectionResponseVO extends BaseVO {

    private String title;

    private String description;

    private Boolean draft;

    public InspectionResponseVO() {
    }

    public InspectionResponseVO(final UUID id,
                                final String title,
                                final String description,
                                final Boolean draft) {
        this.setId(id);
        this.title = title;
        this.description = description;
        this.draft = draft;
    }

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

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(final Boolean draft) {
        this.draft = draft;
    }
}

package com.checkup.userinformation;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "createdAt", "updatedAt"})
public class UserInformationVO implements BaseVO {

    private UUID id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 100)
    private String title;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 150)
    private String description;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;


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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
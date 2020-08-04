package com.checkup.target.information;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "createdAt", "updatedAt"})
public class TargetInformationVO implements BaseVO {

    @Mapping("id")
    @JsonProperty("id")
    private UUID key;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "title")
    @Size(max = 100)
    private String title;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "description")
    @Size(max = 4000)
    private String description;

    @NotNull
    private Integer positionIndex;

    @NotNull
    private Boolean active = Boolean.TRUE;

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

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(final UUID key) {
        this.key = key;
    }
}

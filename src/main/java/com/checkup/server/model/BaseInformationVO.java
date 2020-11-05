package com.checkup.server.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseInformationVO extends BaseVO {

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

    public BaseInformationVO() {
    }

    public BaseInformationVO(final UUID id,
                             final String title,
                             final String description,
                             final Integer positionIndex,
                             final Boolean active) {
        setId(id);
        this.title = title;
        this.description = description;
        this.positionIndex = positionIndex;
        this.active = active;
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
}
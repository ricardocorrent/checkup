package com.checkup.target;

import com.checkup.server.model.BaseVO;
import com.checkup.target.information.TargetInformationVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "active", "information", "createdAt", "updatedAt"})
public class TargetVO implements BaseVO {

    @Mapping("id")
    @JsonProperty("id")
    private UUID key;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 255)
    private String name;

    private Boolean active;

    private List<TargetInformationVO> information;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @Override
    public UUID getKey() {
        return key;
    }

    @Override
    public void setKey(UUID key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<TargetInformationVO> getInformation() {
        return information;
    }

    public void setInformation(List<TargetInformationVO> information) {
        this.information = information;
    }
}

package com.checkup.target;

import com.checkup.server.model.BaseVO;
import com.checkup.target.information.TargetInformationVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "name", "active", "information", "createdAt", "updatedAt"})
public class TargetDTO extends BaseVO {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    private Boolean active;

    private List<TargetInformationVO> information;

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


    public List<TargetInformationVO> getInformation() {
        return information;
    }

    public void setInformation(List<TargetInformationVO> information) {
        this.information = information;
    }
}

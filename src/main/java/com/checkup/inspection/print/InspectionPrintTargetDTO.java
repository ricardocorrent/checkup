package com.checkup.inspection.print;

import com.checkup.server.model.BaseVO;
import com.checkup.target.information.TargetInformationVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "name", "active", "information"})
public class InspectionPrintTargetDTO extends BaseVO {

    private String name;

    private Boolean active;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private List<InspectionPrintTargetInformationDTO> information;

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

    public List<InspectionPrintTargetInformationDTO> getInformation() {
        return information;
    }

    public void setInformation(List<InspectionPrintTargetInformationDTO> information) {
        this.information = information;
    }
}

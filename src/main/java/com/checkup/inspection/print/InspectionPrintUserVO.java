package com.checkup.inspection.print;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "fullName", "information"})
public class InspectionPrintUserVO extends BaseVO {

    private String fullName;

    private List<InspectionPrintUserInformationDTO> information;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public List<InspectionPrintUserInformationDTO> getInformation() {
        return information;
    }

    public void setInformation(final List<InspectionPrintUserInformationDTO> information) {
        this.information = information;
    }

}
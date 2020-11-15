package com.checkup.inspection.print;

import com.checkup.server.model.BaseInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active"})
public class InspectionPrintUserInformationDTO extends BaseInformationVO {
}
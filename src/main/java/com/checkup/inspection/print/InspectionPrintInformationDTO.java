package com.checkup.inspection.print;

import com.checkup.server.model.BaseInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "description", "positionIndex"})
public class InspectionPrintInformationDTO extends BaseInformationVO {
}

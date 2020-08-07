package com.checkup.inspection.information;

import com.checkup.server.model.BaseInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "createdAt", "updatedAt"})
public class InspectionInformationVO extends BaseInformationVO {
}

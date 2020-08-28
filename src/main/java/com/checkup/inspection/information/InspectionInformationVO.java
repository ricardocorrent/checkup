package com.checkup.inspection.information;

import com.checkup.server.model.BaseInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "createdAt", "updatedAt"})
public class InspectionInformationVO extends BaseInformationVO {

    public InspectionInformationVO() {
    }

    public InspectionInformationVO(final UUID id, final String title, final String description, final Integer positionIndex, final Boolean active) {
        super(id, title, description, positionIndex, active);
    }
}

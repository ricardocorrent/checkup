package com.checkup.inspection.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id"})
public class InspectionCloseVO extends BaseVO {

    public InspectionCloseVO() {
    }

    public InspectionCloseVO(final UUID id) {
        this.setId(id);
    }
}

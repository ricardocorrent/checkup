package com.checkup.inspection.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"id", "title", "description", "draft", "syncQuantities", "allowedToSync", "note", "information", "user", "target"})
public class InspectionFinalizeVO extends BaseVO {

    public InspectionFinalizeVO() {
    }

    public InspectionFinalizeVO(final UUID id) {
        this.setId(id);
    }
}

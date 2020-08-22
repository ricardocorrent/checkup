package com.checkup.inspection.vo;

import com.checkup.server.model.BaseVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "description", "draft", "syncQuantities", "allowedToSync", "note", "information", "user", "target"})
public class InspectionFinalizeVO extends BaseVO {

}

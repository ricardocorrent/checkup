package com.checkup.user.information;

import com.checkup.server.model.BaseInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "description", "positionIndex", "active", "createdAt", "updatedAt"})
public class UserInformationVO extends BaseInformationVO {
}
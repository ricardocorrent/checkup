package com.checkup.user;

import com.checkup.server.model.BaseVO;
import com.checkup.user.information.UserInformationVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.OffsetDateTime;
import java.util.List;

@JsonPropertyOrder({"id", "userName", "fullName", "information", "createdAt", "updatedAt"})
public class UserVO extends BaseVO {

    private String userName;

    private String fullName;

    private List<UserInformationVO> information;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public List<UserInformationVO> getInformation() {
        return information;
    }

    public void setInformation(final List<UserInformationVO> information) {
        this.information = information;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
package com.checkup.inspection.vo;

import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.server.model.BaseVO;
import com.checkup.target.TargetDTO;
import com.checkup.user.UserVO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({"id", "title", "description", "draft", "syncQuantities", "note", "allowedToSync", "target", "user", "information", "topics", "createdAt", "updatedAt"})
public class InspectionCompleteVO extends BaseVO {
    private String title;

    private String description;

    private Boolean draft;

    private Integer syncQuantities;

    private String note;

    private Boolean allowedToSync;

    private TargetDTO target;

    private UserVO user;

    private List<InspectionInformationVO> information;

    private List<InspectionCompleteTopicVO> topics;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(final Boolean draft) {
        this.draft = draft;
    }

    public Integer getSyncQuantities() {
        return syncQuantities;
    }

    public void setSyncQuantities(final Integer syncQuantities) {
        this.syncQuantities = syncQuantities;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public Boolean getAllowedToSync() {
        return allowedToSync;
    }

    public void setAllowedToSync(final Boolean allowedToSync) {
        this.allowedToSync = allowedToSync;
    }

    public TargetDTO getTarget() {
        return target;
    }

    public void setTarget(final TargetDTO target) {
        this.target = target;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(final UserVO user) {
        this.user = user;
    }

    public List<InspectionInformationVO> getInformation() {
        return information;
    }

    public void setInformation(final List<InspectionInformationVO> information) {
        this.information = information;
    }

    public List<InspectionCompleteTopicVO> getTopics() {
        return topics;
    }

    public void setTopics(final List<InspectionCompleteTopicVO> topics) {
        this.topics = topics;
    }
}

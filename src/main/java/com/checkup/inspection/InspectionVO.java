package com.checkup.inspection;

import com.checkup.inspection.information.InspectionInformation;
import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.server.model.BaseVO;
import com.checkup.target.Target;
import com.checkup.target.TargetVO;
import com.checkup.user.User;
import com.checkup.user.UserVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "draft", "syncQuantities", "note", "allowedToSync", "information", "user", "target"})
public class InspectionVO extends BaseVO {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String description;

    @NotNull
    private Boolean draft;

    private Integer syncQuantities;

    @Size(max = 4000)
    private String note;

    private Boolean allowedToSync;

    @Valid
    private List<InspectionInformationVO> information;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private UserVO user;

    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private TargetVO target;

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

    public List<InspectionInformationVO> getInformation() {
        return information;
    }

    public void setInformation(final List<InspectionInformationVO> information) {
        this.information = information;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(final UserVO user) {
        this.user = user;
    }

    public TargetVO getTarget() {
        return target;
    }

    public void setTarget(final TargetVO target) {
        this.target = target;
    }
}

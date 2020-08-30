package com.checkup.inspection.vo;

import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.server.model.BaseVO;
import com.checkup.topic.vo.TopicVO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class InspectionCompleteVO extends BaseVO {
    private String title;

    private String description;

    private Boolean draft;

    private Integer syncQuantities;

    private String note;

    private Boolean allowedToSync;

    private List<InspectionInformationVO> information;

    private List<TopicVO> topics;
}

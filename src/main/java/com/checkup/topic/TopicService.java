package com.checkup.topic;

import com.checkup.inspection.Inspection;
import com.checkup.inspection.InspectionRepository;
import com.checkup.server.SimpleAbstractService;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.validation.exception.RegisterNotFoundException;
import com.checkup.topic.vo.TopicVO;
import com.checkup.topic.vo.TopicsByInspectionIdResponseInspectionVO;
import com.checkup.topic.vo.TopicsByInspectionIdResponseTopicVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class TopicService extends SimpleAbstractService<Topic, TopicVO> {

    private final TopicRepository topicRepository;
    private final InspectionRepository inspectionRepository;
    private final TopicValidator topicValidator;

    @Inject
    public TopicService(final TopicRepository topicRepository,
                        final InspectionRepository inspectionRepository) {
        this.topicRepository = topicRepository;
        this.inspectionRepository = inspectionRepository;
        this.topicValidator = new TopicValidator(topicRepository);
    }

    @Override
    public TopicVO insert(final TopicVO topicVO) {
        final Topic t = convertEntityVOToEntity(topicVO);
        topicValidator.validate(t);
        return convertEntityToEntityVO(topicRepository.save(t));
    }

    @Override
    public Class<TopicVO> getClazz() {
        return TopicVO.class;
    }

    @Override
    public Class<Topic> getEntityClazz() {
        return Topic.class;
    }

    public TopicsByInspectionIdResponseInspectionVO getTopicsByInspectionId(final UUID inspectionId) {
        final Inspection inspection = inspectionRepository.findById(inspectionId).orElseThrow(RegisterNotFoundException::new);
        return createResponseToSendTopicsByInspectionId(topicRepository.findByInspectionId(inspection.getId()), inspection);
    }

    private TopicsByInspectionIdResponseInspectionVO createResponseToSendTopicsByInspectionId(final List<Topic> topicList, final Inspection inspection) {
        final TopicsByInspectionIdResponseInspectionVO response = new TopicsByInspectionIdResponseInspectionVO();
        response.setId(inspection.getId());
        response.setTitle(inspection.getTitle());
        response.setDescription(inspection.getDescription());
        response.setTopics(DozerAdapter.parseListObjects(topicList, TopicsByInspectionIdResponseTopicVO.class));
        return response;
    }
}

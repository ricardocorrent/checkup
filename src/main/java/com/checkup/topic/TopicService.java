package com.checkup.topic;

import com.checkup.server.SimpleAbstractService;
import com.checkup.topic.vo.TopicVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TopicService extends SimpleAbstractService<Topic, TopicVO> {

    private final TopicRepository topicRepository;

    @Inject
    public TopicService(final TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Class<TopicVO> getClazz() {
        return TopicVO.class;
    }

    @Override
    public Class<Topic> getEntityClazz() {
        return Topic.class;
    }
}

package com.checkup.topic;

import com.checkup.server.validation.exception.DuplicateTopicException;

import java.util.List;
import java.util.Optional;

public class TopicValidator {

    private final TopicRepository topicRepository;

    public TopicValidator(final TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void validate(final Topic topic) {
        List<Topic> topicFromDb = topicRepository.findByInspectionIdAndItemId(topic.getInspection().getId(), topic.getItem().getId());
        if (!topicFromDb.isEmpty()) throw new DuplicateTopicException();
    }
}

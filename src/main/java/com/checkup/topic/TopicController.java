package com.checkup.topic;

import com.checkup.server.SimpleAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/topic")
public class TopicController extends SimpleAbstractController<Topic, TopicVO> {

    private final TopicService topicService;

    @Inject
    public TopicController(final TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public ResponseEntity<?> listAll(int page, int limit, String direction, PagedResourcesAssembler<TopicVO> assembler) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    protected String getListAllSortProperty() {
        return null;
    }
}

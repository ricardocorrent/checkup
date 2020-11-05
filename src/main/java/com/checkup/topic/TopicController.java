package com.checkup.topic;

import com.checkup.server.SimpleAbstractController;
import com.checkup.topic.vo.TopicVO;
import com.checkup.topic.vo.TopicsByInspectionIdResponseInspectionVO;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/topic")
public class TopicController extends SimpleAbstractController<Topic, TopicVO> {

    private final TopicService topicService;

    public TopicController(final TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public ResponseEntity<?> listAll(int page, int size, String direction, PagedResourcesAssembler<TopicVO> assembler) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    protected String getListAllSortProperty() {
        return "positionIndex";
    }

    @GetMapping(path = "/inspection/{inspectionId}", produces = {"application/json"})
    public ResponseEntity<?> getEntitiesByInspectionId(@PathVariable("inspectionId") final UUID id) {
        final TopicsByInspectionIdResponseInspectionVO topicsByInspectionId = topicService.getTopicsByInspectionId(id);
        return ResponseEntity.ok(topicsByInspectionId);
    }
}

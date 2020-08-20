package com.checkup.topic;

import com.checkup.server.SimpleAbstractController;
import com.checkup.topic.vo.TopicVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/topic")
public class TopicController extends SimpleAbstractController<Topic, TopicVO> {

    @Override
    protected String getListAllSortProperty() {
        return "positionIndex";
    }
}

package com.checkup.file;

import com.checkup.file.vo.FileVO;
import com.checkup.server.SimpleAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/file")
public class FileController extends SimpleAbstractController<File, FileVO> {

    private final FileService fileService;

    @Autowired
    public FileController(final FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    protected String getListAllSortProperty() {
        return "positionIndex";
    }
}

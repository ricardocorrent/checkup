package com.checkup.file;

import com.checkup.file.vo.FileVO;
import com.checkup.server.SimpleAbstractController;
import com.checkup.server.adapter.DozerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping(value = "/batch-insert")
    private ResponseEntity<?> insert(@Valid @RequestBody final List<FileVO> files) {
        final List<File> fileList = DozerAdapter.parseListObjects(files, File.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fileService.batchInsert(fileList));
    }

}

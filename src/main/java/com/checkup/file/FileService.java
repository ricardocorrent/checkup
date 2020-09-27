package com.checkup.file;

import com.checkup.file.vo.FileVO;
import com.checkup.server.SimpleAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService extends SimpleAbstractService<File, FileVO> {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(final FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Class<FileVO> getClazz() {
        return FileVO.class;
    }

    @Override
    public Class<File> getEntityClazz() {
        return File.class;
    }
}

package com.checkup.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/upload")
    public AttachmentUploadResponse uploadFile(@RequestParam("file") final MultipartFile file) {
        final Attachment attachment = attachmentService.storeFile(file);

        final String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/attachment/download/")
                .path(attachment.getId().toString())
                .toUriString();

        return new AttachmentUploadResponse(attachment.getId(), attachment.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/batch-upload")
    public List<AttachmentUploadResponse> uploadMultipleFiles(@RequestParam("file") final MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable UUID fileId) {
        // Load file from database
        Attachment attachment = attachmentService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFileName() + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }

}

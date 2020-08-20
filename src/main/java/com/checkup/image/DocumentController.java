package com.checkup.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController {

    @Autowired
    private DocumentStorageService documneStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("topicId") UUID topicId,
                                         @RequestParam("positionIndex") Integer positionIndex,
                                         @RequestParam("note") String note,
                                         @RequestParam("docType") String docType) {
        final DocumentStorageVO documentStorageVO = new DocumentStorageVO();
        documentStorageVO.setTopicId(topicId);
        documentStorageVO.setPositionIndex(positionIndex);
        documentStorageVO.setNote(note);
        String fileName = documneStorageService.storeFile(file, documentStorageVO, docType);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam("topicId") UUID topicId,
                                                 @RequestParam("docType") String docType,
                                                 HttpServletRequest request) {

        String fileName = documneStorageService.getDocumentName(topicId, docType);
        Resource resource = null;
        if (fileName != null && !fileName.isEmpty()) {
            try {
                resource = documneStorageService.loadFileAsResource(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Try to determine file's content type
            String contentType = null;
            try {
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException ex) {
                //logger.info("Could not determine file type.");
            }
            // Fallback to the default content type if type could not be determined
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } else {

            return ResponseEntity.notFound().build();

        }

    }

}

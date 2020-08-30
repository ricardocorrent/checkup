package com.checkup.attachment;

import com.checkup.server.validation.exception.AttachmentNotFoundException;
import com.checkup.server.validation.exception.AttachmentStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public Attachment storeFile(final MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new AttachmentStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            final Attachment attachment = new Attachment(file.getBytes(), fileName, file.getContentType());

            return attachmentRepository.save(attachment);
        } catch (final IOException ex) {
            throw new AttachmentStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Attachment getFile(final UUID fileId) {
        return attachmentRepository.findById(fileId)
                .orElseThrow(() -> new AttachmentNotFoundException("File not found with id " + fileId));
    }

}

package com.checkup.attachment;

import java.util.UUID;

public class AttachmentUploadResponse {
    private UUID id;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public AttachmentUploadResponse(final UUID id,
                                    final String fileName,
                                    final String fileDownloadUri,
                                    final String fileType,
                                    final long size) {
        this.id = id;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(final String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(final String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(final long size) {
        this.size = size;
    }
}

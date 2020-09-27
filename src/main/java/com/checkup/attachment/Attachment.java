package com.checkup.attachment;

import com.checkup.server.model.PhysicalBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "attachment", schema = "checkup")
public class Attachment extends PhysicalBaseEntity {

    @Lob
    private byte[] data;

    private String fileName;

    private String fileType;

    public Attachment() {
    }

    public byte[] getData() {
        return data;
    }

    public Attachment(final byte[] data, final String fileName, final String fileType) {
        this.data = data;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(final String fileType) {
        this.fileType = fileType;
    }
}

package com.checkup.server.model;

import java.io.Serializable;
import java.util.UUID;

public class IdVO implements Serializable {

    private UUID id;

    public IdVO() {
    }

    public IdVO(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }
}

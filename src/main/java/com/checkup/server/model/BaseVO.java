package com.checkup.server.model;

import java.io.Serializable;
import java.util.UUID;

public interface BaseVO extends Serializable {

    UUID getId();

    void setId(final UUID id);

}
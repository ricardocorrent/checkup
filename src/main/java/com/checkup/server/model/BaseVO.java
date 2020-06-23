package com.checkup.server.model;

public interface BaseVO extends Serializable {

    UUID getKey();

    void setKey(final UUID id);

}
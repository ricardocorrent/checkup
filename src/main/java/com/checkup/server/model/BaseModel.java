package com.checkup.server.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

    public abstract UUID getId();

    public abstract void setId(final UUID id);

    public abstract OffsetDateTime getCreatedAt();

    public abstract void setCreatedAt(final OffsetDateTime createdAt);

    public abstract OffsetDateTime getUpdatedAt();

    public abstract void setUpdatedAt(final OffsetDateTime updatedAt);

}

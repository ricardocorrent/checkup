package com.checkup.server.model;

import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class PrototypePattern extends PhysicalBaseEntity {

    public PrototypePattern() {
    }

    public PrototypePattern(final PrototypePattern target) {
        if (target != null) {
            this.setCreatedAt(OffsetDateTime.now());
            this.setUpdatedAt(OffsetDateTime.now());
        }
    }

    public abstract PrototypePattern clone();

}

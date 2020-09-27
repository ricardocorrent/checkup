package com.checkup.server.model;

import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class PrototypePhysicalBaseEntity extends PhysicalBaseEntity {

    public PrototypePhysicalBaseEntity() {
    }

    public PrototypePhysicalBaseEntity(final PrototypePhysicalBaseEntity target) {
        if (target != null) {
            this.setCreatedAt(OffsetDateTime.now());
            this.setUpdatedAt(OffsetDateTime.now());
        }
    }

    public abstract PrototypePhysicalBaseEntity clone();

}

package com.checkup.server.model;

import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class PrototypeInformationPattern extends BaseInformation {

    public PrototypeInformationPattern() {
    }

    public PrototypeInformationPattern(final PrototypeInformationPattern target) {
        if (target != null) {
            this.setTitle(target.getTitle());
            this.setDescription(target.getDescription());
            this.setActive(target.getActive());
            this.setPositionIndex(target.getPositionIndex());
            this.setCreatedAt(OffsetDateTime.now());
            this.setUpdatedAt(OffsetDateTime.now());
        }
    }

    public abstract PrototypeInformationPattern clone();

}

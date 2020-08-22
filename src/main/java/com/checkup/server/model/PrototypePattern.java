package com.checkup.server.model;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class PrototypePattern extends PhysicalBaseEntity{

    public PrototypePattern() {
    }

    public PrototypePattern(PrototypePattern target) {
    }

    public abstract PrototypePattern clone();

}

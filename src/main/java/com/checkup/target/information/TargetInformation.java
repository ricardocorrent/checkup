package com.checkup.target.information;

import com.checkup.server.model.BaseInformation;
import com.checkup.server.model.PrototypeInformationPattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "target_information", schema = "checkup")
public class TargetInformation extends PrototypeInformationPattern {

    public TargetInformation() {
    }

    public TargetInformation(final PrototypeInformationPattern target) {
        super(target);
    }

    @Override
    public PrototypeInformationPattern clone() {
        return new TargetInformation(this);
    }
}

package com.checkup.inspection.information;

import com.checkup.server.model.PrototypeInformationPattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inspection_information", schema = "checkup")
public class InspectionInformation extends PrototypeInformationPattern {

    public InspectionInformation() {
    }

    public InspectionInformation(final InspectionInformation target) {
        super(target);
    }

    @Override
    public InspectionInformation clone() {
        return new InspectionInformation(this);
    }
}

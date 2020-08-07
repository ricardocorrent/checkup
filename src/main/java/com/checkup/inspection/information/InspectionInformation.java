package com.checkup.inspection.information;

import com.checkup.server.model.BaseInformation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inspection_information", schema = "checkup")
public class InspectionInformation extends BaseInformation {
}

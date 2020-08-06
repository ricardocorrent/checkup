package com.checkup.target.information;

import com.checkup.server.model.BaseInformation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "target_information", schema = "checkup")
public class TargetInformation extends BaseInformation {

}

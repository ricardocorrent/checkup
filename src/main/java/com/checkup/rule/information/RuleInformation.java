package com.checkup.rule.information;

import com.checkup.server.model.BaseInformation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rule_information", schema = "checkup")
public class RuleInformation extends BaseInformation {
}

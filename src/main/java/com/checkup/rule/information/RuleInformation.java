package com.checkup.rule.information;

import com.checkup.server.model.PrototypeInformationPattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rule_information", schema = "checkup")
public class RuleInformation extends PrototypeInformationPattern {

    public RuleInformation() {
    }

    public RuleInformation(final RuleInformation ruleInformation) {
        super(ruleInformation);
    }

    @Override
    public RuleInformation clone() {
        return new RuleInformation(this);
    }
}

package com.checkup.item.information;

import com.checkup.server.model.PrototypeInformationPattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item_information", schema = "checkup")
public class ItemInformation extends PrototypeInformationPattern {

    public ItemInformation() {
    }

    public ItemInformation(final ItemInformation itemInformation) {
        super(itemInformation);
    }

    @Override
    public ItemInformation clone() {
        return new ItemInformation(this);
    }
}

package com.checkup.item.information;

import com.checkup.server.model.BaseInformation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item_information", schema = "checkup")
public class ItemInformation extends BaseInformation {
}

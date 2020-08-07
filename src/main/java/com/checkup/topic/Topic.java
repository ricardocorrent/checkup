package com.checkup.topic;

import com.checkup.inspection.Inspection;
import com.checkup.item.Item;
import com.checkup.server.model.PhysicalBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "topic")
public class Topic extends PhysicalBaseEntity {

    @ManyToOne
    @JoinColumn(name = "inspection_id", nullable = false, insertable = false, updatable = false)
    private Inspection inspection;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private Boolean printInReport;

    private Integer positionIndex;

    private Boolean active = Boolean.TRUE;



}

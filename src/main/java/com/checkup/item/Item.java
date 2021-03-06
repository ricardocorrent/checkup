package com.checkup.item;

import com.checkup.item.information.ItemInformation;
import com.checkup.rule.Rule;
import com.checkup.server.model.PrototypePhysicalBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "item", schema = "checkup")
public class Item extends PrototypePhysicalBaseEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String title;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 4000)
    private String description;

    @NotNull
    private Integer positionIndex;

    @NotNull
    private Boolean active = Boolean.TRUE;

    @Column(updatable = false)
    private Boolean cloned = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "item_id", nullable = false)
    private List<ItemInformation> information;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "rule_id", nullable = false)
    private Rule rule;

    public Item() {
    }

    public Item(final Item item) {
        super(item);
        if (item != null) {
            this.title = item.title;
            this.description = item.description;
            this.positionIndex = item.positionIndex;
            this.active = item.active;
            this.cloned = Boolean.TRUE;
            this.information =
                    item.information
                            .stream()
                            .map(ItemInformation::clone)
                            .collect(Collectors.toList());
            this.rule = item.rule;
        }
    }

    @Override
    public Item clone() {
        return new Item(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(Integer positionIndex) {
        this.positionIndex = positionIndex;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCloned() {
        return cloned;
    }

    public void setCloned(final Boolean cloned) {
        this.cloned = cloned;
    }

    public List<ItemInformation> getInformation() {
        return information;
    }

    public void setInformation(List<ItemInformation> information) {
        this.information = information;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}

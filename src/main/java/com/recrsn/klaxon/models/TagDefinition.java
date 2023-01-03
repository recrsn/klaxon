package com.recrsn.klaxon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TagDefinition extends AbstractAuditedEntity {
    @Id
    private String key;

    @Column
    private String description;

    protected TagDefinition() {
    }

    public TagDefinition(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.recrsn.klaxon.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Tag extends AbstractAuditedEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private TagDefinition definition;

    @Column
    private String value;

    protected Tag() {
    }

    public Tag(TagDefinition tagDefinition, String value) {
        this.definition = tagDefinition;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public TagDefinition getDefinition() {
        return definition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

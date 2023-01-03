package com.recrsn.klaxon.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(indexes = {@Index(
        name = "component_key",
        columnList = "component_id,key",
        unique = true)})
public class EventDefinition extends AbstractAuditedEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String key;

    @Column
    private String description;

    @ManyToOne
    private Component component;

    @ManyToOne
    private Environment environment;

    protected EventDefinition() {
    }

    public EventDefinition(Environment environment, Component component, String key) {
        this.component = component;
        this.environment = environment;
        this.key = key;
    }

    public UUID getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

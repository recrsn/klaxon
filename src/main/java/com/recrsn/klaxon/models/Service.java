package com.recrsn.klaxon.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
public class Service extends AbstractAuditedEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String key;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    private List<Environment> environments;

    protected Service() {
    }

    public Service(String key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Service(String serviceKey) {
        this.key = serviceKey;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<Environment> environments) {
        this.environments = environments;
    }
}

package com.recrsn.klaxon.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(indexes = {@Index(
        name = "service_key",
        columnList = "service_id,key",
        unique = true)
})
public class Component extends AbstractAuditedEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String key;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Service service;

    protected Component() {
    }

    public Component(Service service, String componentKey) {
        this.service = service;
        this.key = componentKey;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}

package com.recrsn.klaxon.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event extends AbstractAuditedEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Level level;

    @Column(columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Map<String, String> data;

    @ManyToOne
    private EventDefinition definition;

    @ManyToMany
    private Set<Tag> tags;

    protected Event() {
    }

    public Event(EventDefinition definition, Level level, Map<String, String> data) {
        this.level = level;
        this.definition = definition;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> metadata) {
        this.data = metadata;
    }

    public EventDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(EventDefinition definition) {
        this.definition = definition;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public enum Level {
        UNSPECIFIED,
        INFO,
        WARNING,
        ERROR
    }


}

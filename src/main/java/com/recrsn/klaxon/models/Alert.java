package com.recrsn.klaxon.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Alert extends AbstractAuditedEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(columnDefinition = "JSONB")
    @Type(type = "jsonb")
    private List<Condition> conditions;

    @Column
    private Severity severity;

    @ManyToOne
    private Environment environment;

    @ManyToOne
    private Component component;

    protected Alert() {
    }

    public Alert(String name, String description, List<Condition> conditions, Severity severity, Environment environment, Component component) {
        this.name = name;
        this.description = description;
        this.conditions = conditions;
        this.severity = severity;
        this.environment = environment;
        this.component = component;
    }

    public UUID getId() {
        return id;
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

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public enum Severity {
        FATAL,
        CRITICAL,
        WARNING,
        INFO
    }

    public enum Operator {
        EQUALS,
        NOT_EQUALS,
        GREATER_THAN,
        LESS_THAN,
        GREATER_THAN_OR_EQUAL_TO,
        LESS_THAN_OR_EQUAL_TO
    }

    public record Condition(String expression, Operator operator, String value) {
    }
}

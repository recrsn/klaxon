package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Alert;

import java.util.UUID;

public record AlertSummary(
        UUID id,
        String name,
        String description,
        Alert.Severity severity,
        EnvironmentSummary environment,
        ServiceSummary service,
        ComponentSummary component) {
    public static AlertSummary from(Alert alert) {
        return new AlertSummary(
                alert.getId(),
                alert.getName(),
                alert.getDescription(),
                alert.getSeverity(),
                EnvironmentSummary.from(alert.getEnvironment()),
                ServiceSummary.from(alert.getComponent().getService()),
                ComponentSummary.from(alert.getComponent())
        );
    }
}

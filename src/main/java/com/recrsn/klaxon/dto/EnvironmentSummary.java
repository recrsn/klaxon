package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Environment;

import java.util.UUID;

public record EnvironmentSummary(UUID id, String key, String name, String description) {
    public static EnvironmentSummary from(Environment environment) {
        return new EnvironmentSummary(environment.getId(), environment.getKey(),
                environment.getName(),
                environment.getDescription());
    }
}

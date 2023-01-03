package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Component;

import java.util.UUID;

public record ComponentSummary(UUID id, String key, String name, String description) {
    public static ComponentSummary from(Component component) {
        return new ComponentSummary(component.getId(), component.getKey(), component.getName(),
                component.getDescription());
    }
}

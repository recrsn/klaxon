package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Service;
import dev.hilla.Nonnull;

import java.util.UUID;

public record ServiceSummary(
        @Nonnull UUID id,
        @Nonnull String key,
        String name,
        String description) {
    public static ServiceSummary from(Service service) {
        return new ServiceSummary(service.getId(), service.getKey(), service.getName(),
                service.getDescription());
    }
}

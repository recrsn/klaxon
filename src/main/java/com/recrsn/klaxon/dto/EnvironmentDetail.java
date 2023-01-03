package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Environment;
import dev.hilla.Nonnull;

import java.util.List;
import java.util.UUID;

public record EnvironmentDetail(@Nonnull UUID id,
                                @Nonnull String key,
                                String name,
                                String description,
                                @Nonnull List<@Nonnull ServiceSummary> services) {
    public EnvironmentDetail(Environment environment) {
        this(environment.getId(), environment.getKey(), environment.getName(),
                environment.getDescription(),
                environment.getServices()
                        .stream()
                        .map(ServiceSummary::new)
                        .toList());
    }
}

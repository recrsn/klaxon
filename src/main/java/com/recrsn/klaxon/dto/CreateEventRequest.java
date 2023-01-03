package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Event;

import javax.validation.constraints.NotNull;
import java.util.Map;

public record CreateEventRequest(
        @NotNull String key,
        @NotNull String environment,
        @NotNull String service,
        @NotNull String component,
        @NotNull Event.Level level,
        @NotNull Map<String, String> data,
        @NotNull Map<String, String> tags

) {
}

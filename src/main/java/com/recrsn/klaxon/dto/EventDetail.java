package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Event;
import com.recrsn.klaxon.models.Tag;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public record EventDetail(
        UUID id,
        EnvironmentSummary environment,
        ServiceSummary service,
        ComponentSummary component,
        String key,
        Event.Level level,
        Map<String, String> data,
        Map<String, String> tags
) {
    public static EventDetail from(Event event) {
        var definition = event.getDefinition();
        var component = definition.getComponent();
        var tags = event.getTags()
                .stream()
                .collect(Collectors.toMap(t -> t.getDefinition().getKey(), Tag::getValue));
        return new EventDetail(event.getId(),
                EnvironmentSummary.from(definition.getEnvironment()),
                ServiceSummary.from(component.getService()),
                ComponentSummary.from(component),
                event.getDefinition().getKey(),
                event.getLevel(),
                event.getData(),
                tags);
    }
}

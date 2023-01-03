package com.recrsn.klaxon.endpoints;

import com.recrsn.klaxon.dto.EventSummary;
import com.recrsn.klaxon.services.EventManager;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Endpoint
@AnonymousAllowed
public class EventEndpoint {
    private final EventManager eventManager;

    @Autowired
    public EventEndpoint(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Nonnull
    public List<@Nonnull EventSummary> getEventsByEnvironment(@Nonnull String environmentKey) {
        return eventManager.getEventsByEnvironment(environmentKey);
    }

    @Nonnull
    public List<@Nonnull EventSummary> getEventsByService(@Nonnull String environmentKey, @Nonnull String serviceKey) {
        return eventManager.getEventsByService(environmentKey, serviceKey);
    }
}

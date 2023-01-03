package com.recrsn.klaxon.endpoints;

import com.recrsn.klaxon.dto.ComponentSummary;
import com.recrsn.klaxon.services.ComponentManager;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Endpoint
public class ComponentEndpoint {
    private final ComponentManager componentManager;

    @Autowired
    public ComponentEndpoint(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public @Nonnull List<@Nonnull ComponentSummary> list(UUID serviceId) {
        return componentManager.findByServiceId(serviceId).stream()
                .map(ComponentSummary::new)
                .toList();
    }
}

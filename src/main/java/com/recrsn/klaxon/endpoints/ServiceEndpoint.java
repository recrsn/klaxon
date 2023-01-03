package com.recrsn.klaxon.endpoints;

import com.recrsn.klaxon.dto.ServiceRequest;
import com.recrsn.klaxon.dto.ServiceSummary;
import com.recrsn.klaxon.services.ServiceManager;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Endpoint
@AnonymousAllowed
public class ServiceEndpoint {

    private final ServiceManager serviceManager;

    @Autowired
    public ServiceEndpoint(@Nonnull ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Nonnull
    public List<@Nonnull ServiceSummary> list() {
        return serviceManager.findAll()
                .stream()
                .map(ServiceSummary::new)
                .toList();
    }

    @Nonnull
    public ServiceSummary create(@Nonnull ServiceRequest request) {
        return ServiceSummary.from(serviceManager.create(
                request.key(),
                request.name(),
                request.description()));
    }

    @Nonnull
    public ServiceSummary get(@Nonnull String serviceKey) {
        return ServiceSummary.from(serviceManager.findByKey(serviceKey));
    }
}

package com.recrsn.klaxon.endpoints;

import com.recrsn.klaxon.dto.EnvironmentDetail;
import com.recrsn.klaxon.dto.EnvironmentRequest;
import com.recrsn.klaxon.dto.EnvironmentSummary;
import com.recrsn.klaxon.services.EnvironmentManager;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Endpoint
@AnonymousAllowed
public class EnvironmentEndpoint {
    private final EnvironmentManager environmentManager;

    @Autowired
    public EnvironmentEndpoint(@Nonnull EnvironmentManager environmentManager) {
        this.environmentManager = environmentManager;
    }


    @Nonnull
    public List<@Nonnull EnvironmentSummary> list() {
        return environmentManager.findAll()
                .stream()
                .map(EnvironmentSummary::new)
                .toList();
    }

    @Nonnull
    public EnvironmentSummary create(@Nonnull EnvironmentRequest request) {
        return EnvironmentSummary.from(environmentManager.create(
                request.key(),
                request.name(),
                request.description()));
    }

    @Nonnull
    public EnvironmentDetail getDetailByKey(@Nonnull String key) {
        return new EnvironmentDetail(environmentManager.findByKey(key));
    }
}

package com.recrsn.klaxon.services;

import com.recrsn.klaxon.dto.CreateAlertRequest;
import com.recrsn.klaxon.models.Alert;
import com.recrsn.klaxon.repositories.AlertRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertManager {
    private final AlertRepository alertRepository;
    private final EnvironmentManager environmentManager;
    private final ServiceManager serviceManager;
    private final ComponentManager componentManager;

    public AlertManager(AlertRepository alertRepository, EnvironmentManager environmentManager, ServiceManager serviceManager, ComponentManager componentManager) {
        this.alertRepository = alertRepository;
        this.environmentManager = environmentManager;
        this.serviceManager = serviceManager;
        this.componentManager = componentManager;
    }

    public Alert create(CreateAlertRequest request) {
        var environment = environmentManager.getOrCreate(request.environment());
        var service = serviceManager.getOrCreate(request.service());
        var component = componentManager.getOrCreate(service, request.component());

        Alert alert = new Alert(
                request.name(),
                request.description(),
                request.conditions(),
                request.severity(),
                environment,
                component
        );
        alertRepository.save(alert);
        return alert;
    }
}

package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.EventDefinition;
import com.recrsn.klaxon.repositories.EventDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EventDefinitionManager {
    private final EnvironmentManager environmentManager;
    private final ServiceManager serviceManager;
    private final ComponentManager componentManager;
    private final EventDefinitionRepository eventDefinitionRepository;

    @Autowired
    public EventDefinitionManager(EnvironmentManager environmentManager, ServiceManager serviceManager, ComponentManager componentManager, EventDefinitionRepository eventDefinitionRepository) {
        this.environmentManager = environmentManager;
        this.serviceManager = serviceManager;
        this.componentManager = componentManager;
        this.eventDefinitionRepository = eventDefinitionRepository;
    }

    @Transactional
    public EventDefinition getOrCreate(String environmentKey, String serviceKey, String componentKey, String key) {
        var environment = environmentManager.getOrCreate(environmentKey);
        var service = serviceManager.getOrCreate(serviceKey);
        var component = componentManager.getOrCreate(service, componentKey);

        return eventDefinitionRepository.findByEnvironmentAndComponentAndKey(environment, component,
                        key)
                .orElseGet(() -> {
                    var eventDefinition = new EventDefinition(environment, component, key);
                    eventDefinitionRepository.save(eventDefinition);
                    return eventDefinition;
                });
    }
}

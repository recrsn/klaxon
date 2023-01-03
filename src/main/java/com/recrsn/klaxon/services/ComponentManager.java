package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.Component;
import com.recrsn.klaxon.models.Service;
import com.recrsn.klaxon.repositories.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class ComponentManager {
    public final ComponentRepository componentRepository;
    public final ServiceManager serviceManager;

    @Autowired
    public ComponentManager(ComponentRepository componentRepository, ServiceManager serviceManager) {
        this.componentRepository = componentRepository;
        this.serviceManager = serviceManager;
    }

    public List<Component> findByServiceId(UUID serviceId) {
        Service service = serviceManager.findById(serviceId);
        return componentRepository.findByService(service);
    }

    @Transactional
    public Component getOrCreate(Service service, String componentKey) {
        return componentRepository.findByServiceAndKey(service, componentKey).orElseGet(() -> {
            Component component = new Component(service, componentKey);
            componentRepository.save(component);
            return component;
        });
    }
}

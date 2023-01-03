package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.Service;
import com.recrsn.klaxon.repositories.ServiceRepository;
import dev.hilla.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class ServiceManager {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceManager(@Nonnull ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    public Service create(String key, String name, String description) {
        return serviceRepository.save(new Service(key, name, description));
    }

    public Service findById(UUID serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new DataNotFoundException("Service", serviceId.toString()));
    }

    @Transactional
    public Service getOrCreate(String serviceKey) {
        return serviceRepository.findByKey(serviceKey).orElseGet(() -> {
            Service service = new Service(serviceKey);
            serviceRepository.save(service);
            return service;
        });
    }

    public Service findByKey(String serviceKey) {
        return serviceRepository.findByKey(serviceKey)
                .orElseThrow(() -> new DataNotFoundException("Service", serviceKey));
    }
}

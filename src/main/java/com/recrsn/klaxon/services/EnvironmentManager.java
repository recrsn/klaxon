package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.Environment;
import com.recrsn.klaxon.repositories.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnvironmentManager {
    private final EnvironmentRepository environmentRepository;

    @Autowired
    public EnvironmentManager(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }


    public Optional<Environment> findById(UUID id) {
        return environmentRepository.findById(id);
    }

    public List<Environment> findAll() {
        return environmentRepository.findAll();
    }

    public Environment create(String key, String name, String description) {
        return environmentRepository.save(new Environment(key, name, description));
    }

    public Environment findByKey(String key) {
        return environmentRepository.findByKey(key)
                .orElseThrow(() -> new DataNotFoundException("Environment", key));
    }

    @Transactional
    public Environment getOrCreate(String environmentKey) {
        return environmentRepository.findByKey(environmentKey).orElseGet(() -> {
            Environment environment = new Environment(environmentKey);
            environmentRepository.save(environment);
            return environment;
        });
    }
}

package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Component;
import com.recrsn.klaxon.models.Environment;
import com.recrsn.klaxon.models.EventDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventDefinitionRepository extends JpaRepository<EventDefinition, UUID> {
    Optional<EventDefinition> findByEnvironmentAndComponentAndKey(Environment environment, Component component, String key);
}

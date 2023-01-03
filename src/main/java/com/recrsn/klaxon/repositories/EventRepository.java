package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Environment;
import com.recrsn.klaxon.models.Event;
import com.recrsn.klaxon.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByDefinitionEnvironment(Environment environment);

    List<Event> findByDefinitionEnvironmentAndDefinitionComponentService(Environment environment, Service service);
}

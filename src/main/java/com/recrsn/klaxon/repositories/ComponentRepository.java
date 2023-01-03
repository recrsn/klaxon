package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Component;
import com.recrsn.klaxon.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComponentRepository extends JpaRepository<Component, UUID> {
    List<Component> findByService(Service service);

    Optional<Component> findByServiceAndKey(Service service, String componentKey);
}

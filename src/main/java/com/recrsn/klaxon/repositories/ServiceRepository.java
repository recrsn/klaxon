package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
    Optional<Service> findByKey(String key);
}

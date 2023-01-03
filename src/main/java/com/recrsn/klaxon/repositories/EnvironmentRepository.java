package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnvironmentRepository extends JpaRepository<Environment, UUID> {
    Optional<Environment> findByKey(String key);
}

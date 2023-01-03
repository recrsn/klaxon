package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
}

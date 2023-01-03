package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.TagDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagDefinitionRepository extends JpaRepository<TagDefinition, UUID> {
    Optional<TagDefinition> findByKey(String key);
}

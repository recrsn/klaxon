package com.recrsn.klaxon.repositories;

import com.recrsn.klaxon.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}

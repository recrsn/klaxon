package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.TagDefinition;
import com.recrsn.klaxon.repositories.TagDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagDefinitionManager {
    private final TagDefinitionRepository tagDefinitionRepository;

    @Autowired
    public TagDefinitionManager(TagDefinitionRepository tagDefinitionRepository) {
        this.tagDefinitionRepository = tagDefinitionRepository;
    }

    public TagDefinition getOrCreate(String key) {
        return tagDefinitionRepository.findByKey(key)
                .orElseGet(() -> {
                    var tagDefinition = new TagDefinition(key);
                    tagDefinitionRepository.save(tagDefinition);
                    return tagDefinition;
                });
    }
}

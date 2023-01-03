package com.recrsn.klaxon.services;

import com.recrsn.klaxon.models.Tag;
import com.recrsn.klaxon.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagManager {
    private final TagDefinitionManager tagDefinitionManager;
    private final TagRepository tagRepository;

    @Autowired
    public TagManager(TagDefinitionManager tagDefinitionManager, TagRepository tagRepository) {
        this.tagDefinitionManager = tagDefinitionManager;
        this.tagRepository = tagRepository;
    }

    public Set<Tag> create(Map<String, String> tags) {
        var tagList = tags.entrySet().stream().map(entry -> {
            var definition = tagDefinitionManager.getOrCreate(entry.getKey());
            return new Tag(definition, entry.getValue());
        }).collect(Collectors.toSet());
        tagRepository.saveAll(tagList);
        return tagList;
    }
}

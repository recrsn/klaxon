package com.recrsn.klaxon.services;

import com.recrsn.klaxon.dto.CreateEventRequest;
import com.recrsn.klaxon.dto.EventSummary;
import com.recrsn.klaxon.models.Event;
import com.recrsn.klaxon.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventManager {
    private final EventRepository eventRepository;
    private final EventDefinitionManager eventDefinitionManager;
    private final TagManager tagManager;
    private final EnvironmentManager environmentManager;
    private final ServiceManager serviceManager;

    @Autowired
    public EventManager(EventRepository eventRepository, EventDefinitionManager eventDefinitionManager, TagManager tagManager, EnvironmentManager environmentManager, ServiceManager serviceManager) {
        this.eventRepository = eventRepository;
        this.eventDefinitionManager = eventDefinitionManager;
        this.tagManager = tagManager;
        this.environmentManager = environmentManager;
        this.serviceManager = serviceManager;
    }

    @Transactional
    public Event create(CreateEventRequest eventDetail) {
        var definition = eventDefinitionManager.getOrCreate(
                eventDetail.environment(),
                eventDetail.service(),
                eventDetail.component(),
                eventDetail.key()
        );
        Event event = new Event(definition, eventDetail.level(), eventDetail.data());
        var tags = tagManager.create(eventDetail.tags());
        event.setTags(tags);
        eventRepository.save(event);
        return event;
    }

    public List<EventSummary> getEventsByEnvironment(String environmentKey) {
        var environment = environmentManager.findByKey(environmentKey);
        return eventRepository.findByDefinitionEnvironment(environment)
                .stream()
                .map(EventSummary::from)
                .toList();
    }

    public List<EventSummary> getEventsByService(String environmentKey, String serviceKey) {
        var environment = environmentManager.findByKey(environmentKey);
        var service = serviceManager.findByKey(serviceKey);
        return eventRepository.findByDefinitionEnvironmentAndDefinitionComponentService(environment,
                        service)
                .stream()
                .map(EventSummary::from)
                .toList();
    }
}

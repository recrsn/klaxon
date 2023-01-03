package com.recrsn.klaxon.api.v1;

import com.recrsn.klaxon.dto.CreateEventRequest;
import com.recrsn.klaxon.dto.EventDetail;
import com.recrsn.klaxon.services.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/events")
class EventController {

    private final EventManager eventManager;

    @Autowired
    public EventController(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @PostMapping("")
    public EventDetail create(@RequestBody @Valid CreateEventRequest eventDetail) {
        var event = eventManager.create(eventDetail);
        return EventDetail.from(event);
    }
}

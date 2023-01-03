package com.recrsn.klaxon.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DataNotFoundException extends ResponseStatusException {
    public DataNotFoundException(String entity, String id) {
        super(HttpStatus.NOT_FOUND, "Could not find " + entity + ": " + id);
    }
}

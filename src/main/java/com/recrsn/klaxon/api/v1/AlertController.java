package com.recrsn.klaxon.api.v1;

import com.recrsn.klaxon.dto.AlertSummary;
import com.recrsn.klaxon.dto.CreateAlertRequest;
import com.recrsn.klaxon.services.AlertManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alerts")
public class AlertController {
    private final AlertManager alertManager;

    @Autowired
    public AlertController(AlertManager alertManager) {
        this.alertManager = alertManager;
    }

    @PostMapping("")
    public AlertSummary create(CreateAlertRequest request) {
        return AlertSummary.from(alertManager.create(request));
    }
}

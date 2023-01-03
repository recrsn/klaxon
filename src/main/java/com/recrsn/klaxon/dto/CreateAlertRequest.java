package com.recrsn.klaxon.dto;

import com.recrsn.klaxon.models.Alert;

import java.util.List;

public record CreateAlertRequest(
        String name,
        String description,
        List<Alert.Condition> conditions,
        Alert.Severity severity,
        String environment,
        String service,
        String component
) {
}

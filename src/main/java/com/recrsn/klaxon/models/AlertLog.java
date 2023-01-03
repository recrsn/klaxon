package com.recrsn.klaxon.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class AlertLog extends AbstractAuditedEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Instant openedAt;

    @Column
    private Instant closedAt;

    @Column
    private String message;

    @ManyToOne
    private Alert alert;

    protected AlertLog() {
    }

    public UUID getId() {
        return id;
    }

    public Instant getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(Instant openedAt) {
        this.openedAt = openedAt;
    }

    public Instant getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Instant closedAt) {
        this.closedAt = closedAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
}

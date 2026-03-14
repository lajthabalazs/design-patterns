package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public class FireStation extends IncidentChainElement {

    private final String id;

    public FireStation(String id) {
        this.id = id;
    }

    @Override
    public Optional<String> handleIncident(Incident incident) {
        switch (incident.type()) {
            case MEDICAL -> {
                if (IncidentSeverity.MINOR.equals(incident.severity())) {
                    return Optional.of(sendFireEngine(incident));
                }
            }
            case FIRE -> {
                return Optional.of(sendFireEngine(incident));
            }
        }
        return super.handleIncident(incident);
    }

    private String sendFireEngine(Incident incident) {
        return String.format("Station %s sending fire engine for %s", this.id, incident.id());
    }
}

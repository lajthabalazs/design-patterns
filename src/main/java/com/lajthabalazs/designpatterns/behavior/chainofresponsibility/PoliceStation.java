package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public class PoliceStation extends IncidentChainElement {

    private final String id;

    public PoliceStation(String id) {
        this.id = id;
    }

    @Override
    public Optional<String> handleIncident(Incident incident) {
        switch (incident.type()) {
            case MEDICAL -> {
                if (IncidentSeverity.MINOR.equals(incident.severity())) {
                    return Optional.of(sendPatrolCar(incident));
                }
            }
            case SECURITY -> {
                return switch (incident.severity()) {
                    case MINOR -> Optional.of(sendPatrolCar(incident));
                    case MAJOR -> Optional.of(sendSwat(incident));
                };
            }
        }
        return super.handleIncident(incident);
    }

    private String sendPatrolCar(Incident incident) {
        return String.format("Station %s sending patrol car for %s", this.id, incident.id());
    }

    private String sendSwat(Incident incident) {
        return String.format("Station %s sending SWAT unit for %s", this.id, incident.id());
    }
}

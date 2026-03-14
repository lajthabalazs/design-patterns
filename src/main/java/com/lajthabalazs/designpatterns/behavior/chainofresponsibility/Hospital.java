package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Objects;
import java.util.Optional;

public class Hospital extends IncidentChainElement {

    private final String id;

    public Hospital(String id) {
        this.id = id;
    }

    @Override
    public Optional<String> handleIncident(Incident incident) {
        if (Objects.requireNonNull(incident.type()) == IncidentType.MEDICAL) {
            return switch (incident.severity()) {
                case MINOR -> Optional.of(sendLightAmbulance(incident));
                case MAJOR -> Optional.of(sendHeavyAmbulance(incident));
            };
        }
        return super.handleIncident(incident);
    }

    private String sendLightAmbulance(Incident incident) {
        return String.format("Hospital %s sending light ambulance for %s", this.id, incident.id());
    }

    private String sendHeavyAmbulance(Incident incident) {
        return String.format("Hospital %s sending heavy ambulance for %s", this.id, incident.id());
    }
}

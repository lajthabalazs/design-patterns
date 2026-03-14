package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public class IncidentChainElement implements IncidentHandler {
    private IncidentHandler next;

    public void setNext(IncidentHandler next) {
        this.next = next;
    }
    public Optional<String> handleIncident(Incident incident) {
        return next == null ? Optional.empty() : next.handleIncident(incident);
    }
}

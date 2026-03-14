package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public class FailedIncidentChainElement extends IncidentChainElement {
    @Override
    public Optional<String> handleIncident(Incident incident) {
        return super.handleIncident(incident);
    }
}

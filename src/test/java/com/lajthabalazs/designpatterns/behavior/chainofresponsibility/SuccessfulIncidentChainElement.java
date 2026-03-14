package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public class SuccessfulIncidentChainElement extends IncidentChainElement {
    private final String id;

    public SuccessfulIncidentChainElement(String id) {
        this.id = id;
    }

    @Override
    public Optional<String> handleIncident(Incident incident) {
        return Optional.of(id);
    }
}

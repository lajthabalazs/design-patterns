package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Incident;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentChainElement;

import java.util.Optional;

public class FailedIncidentChainElement extends IncidentChainElement {
    @Override
    public Optional<String> handleIncident(Incident incident) {
        return super.handleIncident(incident);
    }
}

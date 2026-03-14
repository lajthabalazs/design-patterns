package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

import java.util.Optional;

public interface IncidentHandler {
    void setNext(IncidentHandler next);
    Optional<String> handleIncident(Incident incident);
}

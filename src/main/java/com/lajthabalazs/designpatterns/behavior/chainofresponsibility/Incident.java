package com.lajthabalazs.designpatterns.behavior.chainofresponsibility;

public record Incident(String id, IncidentType type, IncidentSeverity severity) {
}

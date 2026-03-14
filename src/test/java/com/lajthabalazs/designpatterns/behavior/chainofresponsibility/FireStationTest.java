package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.FireStation;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Incident;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentSeverity;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class FireStationTest {

    @Test
    public void handlesMinorMedical() {
        var fireStation = new FireStation("first");
        Optional<String> incidentResponse = fireStation.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the fire station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected medical incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("engine"), "Should send fire engine");
    }

    @Test
    public void doesntHandleMajorMedical() {
        var fireStation = new FireStation("first");
        Optional<String> incidentResponse = fireStation.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MAJOR));
        Assertions.assertFalse(incidentResponse.isPresent(), "Should skip major medical incident.");
    }

    @Test
    public void doesntHandleSecurity() {
        var fireStation = new FireStation("first");
        Optional<String> secondIncidentResponse = fireStation.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MINOR));
        Assertions.assertFalse(secondIncidentResponse.isPresent(), "Should skip minor security incident.");
        Optional<String> firstIncidentResponse = fireStation.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MAJOR));
        Assertions.assertFalse(firstIncidentResponse.isPresent(), "Should skip major security incident.");
    }

    @Test
    public void handlesMinorFire() {
        var fireStation = new FireStation("first");
        Optional<String> incidentResponse = fireStation.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor fire incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the fire station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected fire incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("engine"), "Should send fire engine");
    }

    @Test
    public void handlesMajorFire() {
        var fireStation = new FireStation("first");
        Optional<String> incidentResponse = fireStation.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle major fire incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the fire station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected fire incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("engine"), "Should send fire engine");
    }
}

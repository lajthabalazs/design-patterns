package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Incident;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentSeverity;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentType;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.PoliceStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class PoliceStationTest {

    @Test
    public void handlesMinorMedical() {
        var policeStation = new PoliceStation("first");
        Optional<String> incidentResponse = policeStation.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the police station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected medical incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("patrol"), "Should send patrol car");
    }

    @Test
    public void doesntHandleMajorMedical() {
        var policeStation = new PoliceStation("first");
        Optional<String> incidentResponse = policeStation.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MAJOR));
        Assertions.assertFalse(incidentResponse.isPresent(), "Should skip major medical incident.");
    }

    @Test
    public void doesntHandleFire() {
        var policeStation = new PoliceStation("first");
        Optional<String> secondIncidentResponse = policeStation.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MINOR));
        Assertions.assertFalse(secondIncidentResponse.isPresent(), "Should skip minor fire incident.");
        Optional<String> firstIncidentResponse = policeStation.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertFalse(firstIncidentResponse.isPresent(), "Should skip major fire incident.");
    }

    @Test
    public void sendsPatrolCarForMinorSecurity() {
        var policeStation = new PoliceStation("first");
        Optional<String> incidentResponse = policeStation.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor security incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the police station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected security incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("patrol"), "Should send patrol car");
    }

    @Test
    public void sendsSwatForMajorSecurity() {
        var policeStation = new PoliceStation("first");
        Optional<String> incidentResponse = policeStation.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor security incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the police station");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected security incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("SWAT"), "Should send SWAT");
    }
}

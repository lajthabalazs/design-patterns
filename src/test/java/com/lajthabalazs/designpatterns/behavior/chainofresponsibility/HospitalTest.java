package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Hospital;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Incident;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentSeverity;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class HospitalTest {

    @Test
    public void handlesMinorMedical() {
        var hospital = new Hospital("first");
        Optional<String> incidentResponse = hospital.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the hospital");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected medical incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("light"), "Should send light ambulance");
    }

    @Test
    public void handlesMajorMedical() {
        var hospital = new Hospital("first");
        Optional<String> incidentResponse = hospital.handleIncident(new Incident("unexpected medical incident", IncidentType.MEDICAL, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("first"), "Should contain the id of the hospital");
        Assertions.assertTrue(incidentResponse.get().contains("unexpected medical incident"), "Should contain the id of the incident");
        Assertions.assertTrue(incidentResponse.get().contains("heavy"), "Should send heavy ambulance");
    }

    @Test
    public void doesntHandleFire() {
        var hospital = new Hospital("first");
        Optional<String> secondIncidentResponse = hospital.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MINOR));
        Assertions.assertFalse(secondIncidentResponse.isPresent(), "Should skip minor fire incident.");
        Optional<String> firstIncidentResponse = hospital.handleIncident(new Incident("unexpected fire incident", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertFalse(firstIncidentResponse.isPresent(), "Should skip major fire incident.");
    }

    @Test
    public void doesntHandleSecurity() {
        var hospital = new Hospital("first");
        Optional<String> secondIncidentResponse = hospital.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MINOR));
        Assertions.assertFalse(secondIncidentResponse.isPresent(), "Should skip minor security incident.");
        Optional<String> firstIncidentResponse = hospital.handleIncident(new Incident("unexpected security incident", IncidentType.SECURITY, IncidentSeverity.MAJOR));
        Assertions.assertFalse(firstIncidentResponse.isPresent(), "Should skip major security incident.");
    }
}

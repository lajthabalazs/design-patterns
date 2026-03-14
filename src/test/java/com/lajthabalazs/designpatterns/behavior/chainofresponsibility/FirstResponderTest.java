package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstResponderTest {

    private IncidentChainElement cityChain;

    @BeforeEach
    public void setup() {
        cityChain = new PoliceStation("policeStation");
        var fireStation = new FireStation("fireStation");
        var hospital = new Hospital("hospital");
        fireStation.setNext(hospital);
        cityChain.setNext(fireStation);
    }

    @Test
    public void shouldSendPoliceCarForMinorMedical() {
        var incidentResponse = cityChain.handleIncident(new Incident("minor medical incident", IncidentType.MEDICAL, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("policeStation"), "Should be handled by police");
        Assertions.assertTrue(incidentResponse.get().contains("patrol car"), "Should send patrol car");
    }

    @Test
    public void shouldSendHeavyAmbulanceCarForMajorMedical() {
        var incidentResponse = cityChain.handleIncident(new Incident("major medical incident", IncidentType.MEDICAL, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle major medical incident.");
        Assertions.assertTrue(incidentResponse.get().contains("hospital"), "Should be handled by hospital");
        Assertions.assertTrue(incidentResponse.get().contains("heavy"), "Should send heavy ambulance");
    }

    @Test
    public void shouldSendPatrolCarForMinorSecurity() {
        var incidentResponse = cityChain.handleIncident(new Incident("minor security incident", IncidentType.SECURITY, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor security incident.");
        Assertions.assertTrue(incidentResponse.get().contains("policeStation"), "Should be handled by police");
        Assertions.assertTrue(incidentResponse.get().contains("patrol car"), "Should send patrol car");
    }

    @Test
    public void shouldSendSwatForMajorSecurity() {
        var incidentResponse = cityChain.handleIncident(new Incident("major security incident", IncidentType.SECURITY, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle major security incident.");
        Assertions.assertTrue(incidentResponse.get().contains("policeStation"), "Should be handled by police");
        Assertions.assertTrue(incidentResponse.get().contains("SWAT"), "Should send SWAT");
    }

    @Test
    public void shouldSendFireEngineForMinorFire() {
        var incidentResponse = cityChain.handleIncident(new Incident("minor fire incident", IncidentType.FIRE, IncidentSeverity.MINOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle minor fire incident.");
        Assertions.assertTrue(incidentResponse.get().contains("fireStation"), "Should be handled by fire");
        Assertions.assertTrue(incidentResponse.get().contains("engine"), "Should send fire engine");
    }
    @Test
    public void shouldSendFireEngineForMajorFire() {
        var incidentResponse = cityChain.handleIncident(new Incident("minor fire incident", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Should handle major fire incident.");
        Assertions.assertTrue(incidentResponse.get().contains("fireStation"), "Should be handled by fire");
        Assertions.assertTrue(incidentResponse.get().contains("engine"), "Should send fire engine");
    }
}

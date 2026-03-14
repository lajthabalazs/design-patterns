package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.Incident;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentSeverity;
import com.lajthabalazs.designpatterns.behavior.chainofresponsibility.IncidentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class IncidentChainElementTest {

    @Test
    public void testOneHandlerHandlesIncident() {
        var singleChainElement = new SuccessfulIncidentChainElement("First");
        Optional<String> incidentResponse = singleChainElement.handleIncident(new Incident("1", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Response should be present.");
        Assertions.assertEquals("First", incidentResponse.get());
    }

    @Test
    public void testFirstHandlerHandlesIncident() {
        var firstChainElement = new SuccessfulIncidentChainElement("First");
        var secondChainElement = new SuccessfulIncidentChainElement("Second");
        firstChainElement.setNext(secondChainElement);
        Optional<String> incidentResponse = firstChainElement.handleIncident(new Incident("1", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Response should be present.");
        Assertions.assertEquals("First", incidentResponse.get());
    }

    @Test
    public void testSecondHandlerHandlesIncident() {
        var firstChainElement = new FailedIncidentChainElement();
        var secondChainElement = new SuccessfulIncidentChainElement("Second");
        firstChainElement.setNext(secondChainElement);
        Optional<String> incidentResponse = firstChainElement.handleIncident(new Incident("1", IncidentType.FIRE, IncidentSeverity.MAJOR));
        Assertions.assertTrue(incidentResponse.isPresent(), "Response should be present.");
        Assertions.assertEquals("Second", incidentResponse.get());
    }
}

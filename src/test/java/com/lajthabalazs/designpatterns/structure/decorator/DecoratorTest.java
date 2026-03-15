package com.lajthabalazs.designpatterns.structure.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DecoratorTest {

    @Test
    public void testDecoration() {
        var shop = new SimpleShop();
        var loyaltyPointsDecorator = new LoyaltyPointsDecorator(shop);
        var subscriptionDecorator = new SubscribeToMailingListDecorator(loyaltyPointsDecorator);

        var loyaltyPointTaskList = loyaltyPointsDecorator.sellItem();
        Assertions.assertEquals(
                List.of("Ask for loyalty card", "Take money", "Give item", "Increment points"), loyaltyPointTaskList
        );
        var fullTaskList = subscriptionDecorator.sellItem();
        Assertions.assertEquals(
                List.of("Ask for loyalty card", "Take money", "Give item", "Increment points", "Ask for email", "Add email to mailing list"), fullTaskList
        );
    }
}
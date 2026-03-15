package com.lajthabalazs.designpatterns.structure.decorator;

import java.util.List;
import java.util.stream.Stream;

public class LoyaltyPointsDecorator extends ShopDecorator{

    public static final String ASK_FOR_LOYALTY_CARD = "Ask for loyalty card";
    public static final String INCREMENT_POINTS = "Increment points";

    public LoyaltyPointsDecorator(Shop coreShop) {
        super(coreShop);
    }

    @Override
    public List<String> sellItem() {
        return Stream.concat(Stream.concat(Stream.of(ASK_FOR_LOYALTY_CARD), getCoreShop().sellItem().stream()), Stream.of(INCREMENT_POINTS)).toList();
    }
}
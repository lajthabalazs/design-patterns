package com.lajthabalazs.designpatterns.structure.decorator;

import java.util.List;
import java.util.stream.Stream;

public class SubscribeToMailingListDecorator extends ShopDecorator{

    public static final String ASK_FOR_EMAIL = "Ask for email";
    public static final String ADD_EMAIL_TO_MAILING_LIST = "Add email to mailing list";

    public SubscribeToMailingListDecorator(Shop coreShop) {
        super(coreShop);
    }

    @Override
    public List<String> sellItem() {
        return Stream.concat(getCoreShop().sellItem().stream(), Stream.of(ASK_FOR_EMAIL, ADD_EMAIL_TO_MAILING_LIST)).toList();
    }
}

package com.lajthabalazs.designpatterns.behavior.memento;

import java.util.UUID;

public class Save {
    public final String id;


    public Save() {
        id = UUID.randomUUID().toString();
    }
}

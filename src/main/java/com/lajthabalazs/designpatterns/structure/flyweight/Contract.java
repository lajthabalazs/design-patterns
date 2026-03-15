package com.lajthabalazs.designpatterns.structure.flyweight;

public class Contract {
    private final String text;

    public Contract(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

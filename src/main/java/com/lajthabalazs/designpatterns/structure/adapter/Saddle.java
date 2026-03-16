package com.lajthabalazs.designpatterns.structure.adapter;

public class Saddle implements Selectable{
    private final Horse horse;

    public Saddle(Horse horse) {
        this.horse = horse;
    }

    @Override
    public void select() {
        horse.setHighlighted(true);
    }

    @Override
    public void deselect() {
        horse.setHighlighted(false);
    }
}

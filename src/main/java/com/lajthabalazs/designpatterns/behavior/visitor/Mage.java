package com.lajthabalazs.designpatterns.behavior.visitor;

public class Mage implements Unit{
    private int manna;

    public Mage(int maxManna) {
        this.manna = maxManna;
    }

    @Override
    public void accept(Spell spell) {
        spell.applyToMage(this);
    }

    public void drainManna(int value){
        this.manna = Math.max(0, this.manna - value);
    }

    public int getManna() {
        return manna;
    }
}

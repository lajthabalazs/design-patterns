package com.lajthabalazs.designpatterns.behavior.visitor;

public class Weaken implements Spell {

    private final int level;

    public Weaken(int level) {
        this.level = level;
    }
    @Override
    public void applyToMage(Mage mage) {
        mage.drainManna(level);
    }

    @Override
    public void applyToWarrior(Warrior warrior) {
        warrior.damage(level);
    }
}

package com.lajthabalazs.designpatterns.behavior.visitor;

public interface Spell {
    void applyToMage(Mage mage);
    void applyToWarrior(Warrior warrior);
}

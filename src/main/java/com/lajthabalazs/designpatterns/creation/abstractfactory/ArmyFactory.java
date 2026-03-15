package com.lajthabalazs.designpatterns.creation.abstractfactory;

public interface ArmyFactory {
    Warrior creatWarrior();
    Mage createMage();
    Rogue createRogue();
}

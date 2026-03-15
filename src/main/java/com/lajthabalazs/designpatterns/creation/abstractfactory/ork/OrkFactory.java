package com.lajthabalazs.designpatterns.creation.abstractfactory.ork;

import com.lajthabalazs.designpatterns.creation.abstractfactory.ArmyFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Mage;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Rogue;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Warrior;

public class OrkFactory implements ArmyFactory {

    @Override
    public Warrior creatWarrior() {
        return new Barbarian();
    }

    @Override
    public Mage createMage() {
        return new Warlock();
    }

    @Override
    public Rogue createRogue() {
        return new Assasin();
    }
}

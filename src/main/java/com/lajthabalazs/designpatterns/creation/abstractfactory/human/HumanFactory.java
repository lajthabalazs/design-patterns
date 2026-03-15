package com.lajthabalazs.designpatterns.creation.abstractfactory.human;

import com.lajthabalazs.designpatterns.creation.abstractfactory.ArmyFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Mage;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Rogue;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Warrior;

public class HumanFactory implements ArmyFactory {
    @Override
    public Warrior creatWarrior() {
        return new Champion();
    }

    @Override
    public Mage createMage() {
        return new Sorcerer();
    }

    @Override
    public Rogue createRogue() {
        return new ArcaneTrickster();
    }
}

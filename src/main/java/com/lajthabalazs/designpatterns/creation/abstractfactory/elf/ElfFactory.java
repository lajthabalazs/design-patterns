package com.lajthabalazs.designpatterns.creation.abstractfactory.elf;

import com.lajthabalazs.designpatterns.creation.abstractfactory.ArmyFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Mage;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Rogue;
import com.lajthabalazs.designpatterns.creation.abstractfactory.Warrior;

public class ElfFactory implements ArmyFactory {
    @Override
    public Warrior creatWarrior() {
        return new EldritchKnight();
    }

    @Override
    public Mage createMage() {
        return new HighElf();
    }

    @Override
    public Rogue createRogue() {
        return new Drow();
    }
}

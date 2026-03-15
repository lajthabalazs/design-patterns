package com.lajthabalazs.designpatterns.behavior.visitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTest {

    @Test
    public void testBattlefieldSpell() {
        var battleField = new Battlefield();
        var battleMage = new Mage(50);
        battleField.addUnit(battleMage);
        var sorcerer = new Mage(30);
        battleField.addUnit(sorcerer);
        var apprentice = new Mage(5);
        battleField.addUnit(apprentice);
        var paladdin = new Warrior(100);
        battleField.addUnit(paladdin);
        var knight = new Warrior(40);
        battleField.addUnit(knight);
        var padovan = new Warrior(7);
        battleField.addUnit(padovan);
        battleField.castSpell(new Weaken(10));
        Assertions.assertEquals(40, battleMage.getManna());
        Assertions.assertEquals(20, sorcerer.getManna());
        Assertions.assertEquals(0, apprentice.getManna());
        Assertions.assertEquals(90, paladdin.getHealth());
        Assertions.assertEquals(30, knight.getHealth());
        Assertions.assertEquals(0, padovan.getHealth());
    }
}

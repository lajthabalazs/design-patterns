package com.lajthabalazs.designpatterns.behavior.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StrategyTest {

    @Test
    public void testChooseWeakest() {
        var bottomFeeder = new Warrior(new ChooseWeakest());
        var first = new Targetable(12);
        var second = new Targetable(25);
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(2, first.getHealth());
        Assertions.assertEquals(25, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(0, first.getHealth());
        Assertions.assertEquals(25, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(0, first.getHealth());
        Assertions.assertEquals(15, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(0, first.getHealth());
        Assertions.assertEquals(5, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(0, first.getHealth());
        Assertions.assertEquals(0, second.getHealth());
    }

    @Test
    public void testChooseMoreDamaged() {
        var bottomFeeder = new Warrior(new ChooseMostDamaged());
        var first = new Targetable(12);
        var second = new Targetable(25);
        second.damage(1);
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(12, first.getHealth());
        Assertions.assertEquals(14, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(12, first.getHealth());
        Assertions.assertEquals(4, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(12, first.getHealth());
        Assertions.assertEquals(0, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(2, first.getHealth());
        Assertions.assertEquals(0, second.getHealth());
        bottomFeeder.attack(List.of(first, second));
        Assertions.assertEquals(0, first.getHealth());
        Assertions.assertEquals(0, second.getHealth());
    }

}


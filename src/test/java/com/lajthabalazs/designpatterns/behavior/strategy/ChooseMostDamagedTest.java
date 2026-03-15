package com.lajthabalazs.designpatterns.behavior.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ChooseMostDamagedTest {
    @Test
    public void chooseWeakest() {
        var mostDamaged = new Targetable(120);
        mostDamaged.damage(78);
        var secondWeakest = new Targetable(3);
        var thirdWeakest = new Targetable(15);
        thirdWeakest.damage(11);
        var strogest = new Targetable(400);

        var chosen = new ChooseMostDamaged().chooseTarget(List.of(secondWeakest, thirdWeakest, mostDamaged, strogest));
        Assertions.assertTrue(chosen.isPresent());
        Assertions.assertEquals(mostDamaged, chosen.get());
    }

    @Test
    public void dontChooseDead() {
        var mostDamaged = new Targetable(120);
        mostDamaged.damage(78);
        var dead = new Targetable(0);

        var chosen = new ChooseMostDamaged().chooseTarget(List.of(mostDamaged, dead));
        Assertions.assertTrue(chosen.isPresent());
        Assertions.assertEquals(mostDamaged, chosen.get());
    }

    @Test
    public void handleEmptyList() {
        var chosen = new ChooseMostDamaged().chooseTarget(List.of());
        Assertions.assertTrue(chosen.isEmpty());
    }
}

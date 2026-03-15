package com.lajthabalazs.designpatterns.behavior.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ChooseWeakestTest {

    @Test
    public void chooseWeakest() {
        var weakest = new Targetable(120);
        weakest.damage(119);
        var secondWeakest = new Targetable(3);
        var thirdWeakest = new Targetable(15);
        thirdWeakest.damage(11);
        var tiedThird = new Targetable(4);

        var chosen = new ChooseWeakest().chooseTarget(List.of(secondWeakest, thirdWeakest, weakest, tiedThird));
        Assertions.assertTrue(chosen.isPresent());
        Assertions.assertEquals(weakest, chosen.get());
    }

    @Test
    public void dontChooseDead() {
        var weakest = new Targetable(120);
        weakest.damage(119);
        var dead = new Targetable(0);

        var chosen = new ChooseWeakest().chooseTarget(List.of(weakest, dead));
        Assertions.assertTrue(chosen.isPresent());
        Assertions.assertEquals(weakest, chosen.get());
    }

    @Test
    public void handleEmptyList() {
        var chosen = new ChooseWeakest().chooseTarget(List.of());
        Assertions.assertTrue(chosen.isEmpty());
    }
}

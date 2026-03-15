package com.lajthabalazs.designpatterns.behavior.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TargetableTest {

    @Test
    public void targetableSuffersDamage() {
        var targetable = new Targetable(120);
        targetable.damage(67);
        Assertions.assertEquals(120, targetable.getMaxHealth());
        Assertions.assertEquals(53, targetable.getHealth());
        targetable.damage(31);
        Assertions.assertEquals(120, targetable.getMaxHealth());
        Assertions.assertEquals(22, targetable.getHealth());
        targetable.damage(29);
        Assertions.assertEquals(120, targetable.getMaxHealth());
        Assertions.assertEquals(0, targetable.getHealth());
    }
}

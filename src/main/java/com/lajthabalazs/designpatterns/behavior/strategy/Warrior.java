package com.lajthabalazs.designpatterns.behavior.strategy;

import java.util.List;

public class Warrior extends Targetable {

    private static final int ATTACK_STRENGTH = 10;
    private final ChooseTarget chooseTarget;

    public Warrior(ChooseTarget chooseTarget) {
        super(50);
        this.chooseTarget = chooseTarget;
    }

    public void attack(List<Targetable> enemies) {
        var unit = chooseTarget.chooseTarget(enemies);
        unit.ifPresent(value -> value.damage(ATTACK_STRENGTH));

    }
}

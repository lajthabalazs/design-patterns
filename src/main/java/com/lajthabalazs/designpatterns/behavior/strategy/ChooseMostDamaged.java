package com.lajthabalazs.designpatterns.behavior.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ChooseMostDamaged implements ChooseTarget {
    @Override
    public Optional<Targetable> chooseTarget(List<Targetable> targetables) {
        return targetables.stream().filter(enemy -> enemy.getHealth() > 0).max(Comparator.comparingInt(this::getDamage));
    }

    private int getDamage(Targetable unit) {
        return unit.getMaxHealth() - unit.getHealth();
    }
}

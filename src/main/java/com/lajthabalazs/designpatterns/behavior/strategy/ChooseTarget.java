package com.lajthabalazs.designpatterns.behavior.strategy;


import java.util.List;
import java.util.Optional;

public interface ChooseTarget {
    Optional<Targetable> chooseTarget(List<Targetable> targetables);
}

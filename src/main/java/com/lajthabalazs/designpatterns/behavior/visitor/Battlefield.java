package com.lajthabalazs.designpatterns.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void castSpell(Spell spell) {
        units.forEach(unit -> unit.accept(spell));
    }
}

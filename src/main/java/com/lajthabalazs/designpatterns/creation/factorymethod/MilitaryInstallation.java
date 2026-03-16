package com.lajthabalazs.designpatterns.creation.factorymethod;

public abstract class MilitaryInstallation {

    private int rallyPoint = 0;

    public void setRallyPoint(int location) {
        this.rallyPoint = location;
    }

    public Unit deployUnit() {
        var unit = trainUnit();
        unit.setTarget(this.rallyPoint);
        return unit;
    }

    protected abstract Unit trainUnit();
}

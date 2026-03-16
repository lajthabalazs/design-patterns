package com.lajthabalazs.designpatterns.creation.factorymethod;

public class ArcheryRange extends MilitaryInstallation {
    @Override
    public Unit trainUnit() {
        return new Archer();
    }
}

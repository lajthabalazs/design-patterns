package com.lajthabalazs.designpatterns.creation.factorymethod;

public class Barracks extends MilitaryInstallation{
    @Override
    public Unit trainUnit() {
        return new SwordsMan();
    }
}

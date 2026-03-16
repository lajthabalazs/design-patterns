package com.lajthabalazs.designpatterns.creation.factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BarracksTest {

    @Test
    public void createSwordsMan() {
        var swordsMan = new Barracks().trainUnit();
        Assertions.assertInstanceOf(SwordsMan.class, swordsMan);
    }

    @Test
    public void setsRallyPoint() {
        var barracks = new Barracks();
        barracks.setRallyPoint(10);
        var swordsMan = barracks.deployUnit();
        Assertions.assertEquals(10, swordsMan.getTarget());
        barracks.setRallyPoint(20);
        var secondSwordsMan = barracks.deployUnit();
        Assertions.assertEquals(10, swordsMan.getTarget());
        Assertions.assertEquals(20, secondSwordsMan.getTarget());
    }
}

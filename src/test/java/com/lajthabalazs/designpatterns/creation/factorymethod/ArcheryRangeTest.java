package com.lajthabalazs.designpatterns.creation.factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArcheryRangeTest {

    @Test
    public void createArcher() {
        var archer = new ArcheryRange().trainUnit();
        Assertions.assertInstanceOf(Archer.class, archer);
    }

    @Test
    public void setsRallyPoint() {
        var archeryRange = new ArcheryRange();
        archeryRange.setRallyPoint(10);
        var archer = archeryRange.deployUnit();
        Assertions.assertEquals(10, archer.getTarget());
        archeryRange.setRallyPoint(20);
        var secondArcher = archeryRange.deployUnit();
        Assertions.assertEquals(10, archer.getTarget());
        Assertions.assertEquals(20, secondArcher.getTarget());
    }
}

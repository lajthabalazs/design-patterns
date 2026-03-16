package com.lajthabalazs.designpatterns.structure.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    public void testAdapter() {
        var horse = new Horse();
        var saddle = new Saddle(horse);
        Assertions.assertEquals("Horse", horse.render());
        saddle.select();
        Assertions.assertEquals("Highlighted horse", horse.render());
        saddle.select();
        Assertions.assertEquals("Highlighted horse", horse.render());
        saddle.deselect();
        Assertions.assertEquals("Horse", horse.render());
    }
}

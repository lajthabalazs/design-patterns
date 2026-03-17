package com.lajthabalazs.designpatterns.behavior;

import com.lajthabalazs.designpatterns.behavior.memento.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MementoTest {

    @Test
    public void testGameSaveAndRestore() {
        var game = new Game();
        game.join("Alice");
        game.render();
        game.join("Bob");
        game.render();
        game.advanceGameTime(1000);
        game.render();
        var firstSave = game.save();
        game.join("Carol");
        game.render();
        game.advanceGameTime(2000);
        game.join("Dave");
        game.render();
        game.advanceGameTime(3000);
        game.render();
        Assertions.assertEquals(3000, game.getGameTime());
        Assertions.assertEquals(List.of("Alice", "Bob", "Carol", "Dave"), game.getPlayers());
        long lastRender = game.getLastRenderTime();
        game.restore(firstSave);
        Assertions.assertEquals(lastRender, game.getLastRenderTime());
        Assertions.assertEquals(List.of("Alice", "Bob"), game.getPlayers());
        Assertions.assertEquals(1000, game.getGameTime());
    }
}

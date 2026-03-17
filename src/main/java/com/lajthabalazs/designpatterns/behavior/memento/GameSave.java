package com.lajthabalazs.designpatterns.behavior.memento;

import java.util.List;

public class GameSave extends Save{
    private final long gameTime;
    private final List<String> players;

    public GameSave(long gameTime, List<String> players) {
        super();
        this.gameTime = gameTime;
        this.players = players;
    }

    public long getGameTime() {
        return gameTime;
    }

    public List<String> getPlayers() {
        return List.copyOf(players);
    }
}

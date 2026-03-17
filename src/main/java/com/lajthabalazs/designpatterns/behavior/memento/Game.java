package com.lajthabalazs.designpatterns.behavior.memento;

import java.util.ArrayList;
import java.util.List;

public class Game implements Savable<GameSave> {

    private long gameTime = 0;
    private final List<String> players = new ArrayList<>();
    private long lastRenderTime = 0;

    @Override
    public GameSave save() {
        return new GameSave(gameTime, List.copyOf(players));
    }

    @Override
    public void restore(GameSave save) {
        this.gameTime = save.getGameTime();
        players.clear();
        players.addAll(save.getPlayers());
    }

    public void join(String player) {
        players.add(player);
    }

    public void render() {
        this.lastRenderTime = System.currentTimeMillis();
    }

    public long getLastRenderTime() {
        return this.lastRenderTime;
    }

    public void advanceGameTime(long time) {
        this.gameTime = time;
    }

    public long getGameTime() {
        return this.gameTime;
    }

    public List<String> getPlayers() {
        return List.copyOf(players);
    }
}

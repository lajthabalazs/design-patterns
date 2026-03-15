package com.lajthabalazs.designpatterns.behavior.strategy;

public class Targetable {
    private final int maxHealth;
    private int health;

    public Targetable(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void damage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

}

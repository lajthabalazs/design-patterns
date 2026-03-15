package com.lajthabalazs.designpatterns.behavior.visitor;

public class Warrior implements Unit{

    private int health;

    public Warrior(int maxHealth) {
        this.health = maxHealth;
    }

    @Override
    public void accept(Spell spell) {
        spell.applyToWarrior(this);

    }
    public void damage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public int getHealth(){
        return health;
    }
}

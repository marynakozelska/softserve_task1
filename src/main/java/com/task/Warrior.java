package com.task;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health) {
        this.health = health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void hits(Warrior enemy) {
        enemy.getHitBy(this);
    }

    public int getHitBy(Warrior enemy) {    // returns damage
        this.health -= enemy.getAttack();    // this ? setHealth
        return enemy.getAttack();
    }
}

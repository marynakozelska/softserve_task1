package com.task;

public class Warrior {
    private static final int ATTACK = 5;
    private int health;
    private Warrior warriorBehind;

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

    public void setWarriorBehind(Warrior warriorBehind) {
        this.warriorBehind = warriorBehind;
    }

    public void hits(Warrior enemy) {
        enemy.getHitBy(this);
    }

    public void getHitBy(Warrior enemy) {    // returns damage
        this.health -= enemy.getAttack();    // this ? setHealth
//        return enemy.getAttack();
    }

    public Warrior getWarriorBehind() {
        if (warriorBehind != null) {
            return warriorBehind;
        } else {
            return null;
        }
    }
}

package com.task;

public class Warrior implements canAttack {
    private static final int ATTACK = 5;
    private int health;
    private final int initialHealth;
    private Warrior warriorBehind;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health) {
        this.initialHealth = health;
        this.health = health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    public int getInitialHealth() {
        return initialHealth;
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

    public void getHitBy(Warrior enemy) {
        this.health -= enemy.getAttack();
        if (warriorBehind instanceof Healer) {
            Healer healer = (Healer) warriorBehind;
            healer.heal(this);
        }
    }

    public Warrior getWarriorBehind() {
        if (warriorBehind != null) {
            return warriorBehind;
        } else {
            return null;
        }
    }
}

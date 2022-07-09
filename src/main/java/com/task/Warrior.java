package com.task;

public class Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 5;
    protected int gainedAttack = ATTACK_DEFAULT;
    private int gainedHealth;
    private int maxHealth;
    private Warrior warriorBehind;

    public Warrior() {
        this(50);
    }

    protected Warrior(int health) {
        this.maxHealth = health;
        this.gainedHealth = health;
    }

    public Warrior(int health, int gainedAttack) {
        this(health);
        this.gainedAttack = gainedAttack;
    }

    public int getAttack() {
        return gainedAttack;
    }

    public int getHealth() {
        return gainedHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setAttack(int gainedAttack) {
        this.gainedAttack = gainedAttack;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isAlive() {
        return gainedHealth > 0;
    }

    public void setHealth(int gainedHealth) {
        this.gainedHealth = gainedHealth;
    }

    public void setWarriorBehind(Warrior warriorBehind) {
        this.warriorBehind = warriorBehind;
    }

    public void hits(Warrior enemy) {
        enemy.getHitBy(this);
    }

    public void getHitBy(Warrior enemy) {
        this.gainedHealth = Math.max(0, this.gainedHealth - enemy.getAttack());
        if (warriorBehind instanceof Healer && this.gainedHealth != 0) {
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

    public void equipWeapon(Weapon weapon) {
        this.gainedHealth = Math.max(0, this.gainedHealth + weapon.getHealth());
        maxHealth = getHealth();
        this.gainedAttack += weapon.getAttack();
    }
}

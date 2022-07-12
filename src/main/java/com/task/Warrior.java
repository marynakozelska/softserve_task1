package com.task;

public class Warrior extends HealingProcessor implements CanAttack {
    private static final int ATTACK_DEFAULT = 5;
    protected int gainedAttack = ATTACK_DEFAULT;
    private int gainedHealth;
    private int maxHealth;
    private Warrior warriorBehind;
    private Warrior warriorOnTheRight = null;
    private Warrior warriorOnTheLeft = null;

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

    public Warrior getWarriorOnTheRight() {
        return warriorOnTheRight;
    }

    public Warrior getWarriorOnTheLeft() {
        return warriorOnTheLeft;
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

    public void setWarriorOnTheRight(Warrior warriorOnTheRight) {
        this.warriorOnTheRight = warriorOnTheRight;
    }

    public void setWarriorOnTheLeft(Warrior warriorOnTheLeft) {
        this.warriorOnTheLeft = warriorOnTheLeft;
    }

    public void hits(Warrior enemy) {
        enemy.getHitBy(this);
        this.process(this, null);
    }

    public void getHitBy(CanAttack enemy) {
        setHealth(Math.max(0, this.gainedHealth - enemy.getAttack()));
    }

    public Warrior getWarriorBehind() {
        if (warriorBehind != null) {
            return warriorBehind;
        } else {
            return null;
        }
    }

    public void equipWeapon(Weapon weapon) {
        setMaxHealth(Math.max(0, this.gainedHealth + weapon.getHealth()));
        this.gainedHealth = getMaxHealth();
        this.gainedAttack += weapon.getAttack();
    }
}

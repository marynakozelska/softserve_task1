package com.task;

public class Vampire extends Warrior{
    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hits(Warrior enemy) {
        int damage = enemy.getHitBy(this);
        setHealth(getHealth() + damage * getVampirism() / 100);
    }
}
package com.task;

public class Vampire extends Warrior implements canAttack {
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
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damage = healthBefore - enemy.getHealth();
        setHealth(getHealth() + damage * getVampirism() / 100);
    }
}
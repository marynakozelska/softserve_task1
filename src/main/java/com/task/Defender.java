package com.task;

public class Defender extends Warrior {
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public void getHitBy(Warrior enemy) {
        setHealth(getHealth() - Math.max(0, enemy.getAttack() - getDefense()));
//        return enemy.getAttack() - getDefense();
    }
}

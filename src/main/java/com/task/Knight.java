package com.task;

public class Knight extends Warrior implements canAttack {
    private static final int ATTACK = 7;

    @Override
    public int getAttack() {
        return ATTACK;
    }
}

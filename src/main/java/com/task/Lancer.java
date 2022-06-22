package com.task;

public class Lancer extends Warrior {
    private static final int ATTACK = 6;

    public Lancer() {
        super(50);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

}

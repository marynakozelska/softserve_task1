package com.task;

public class Rookie extends Warrior implements CanAttack {

    public static final int DEFAULT_ATTACK = 1;

    public Rookie() {
        super();
        this.gainedAttack = DEFAULT_ATTACK;
    }
}

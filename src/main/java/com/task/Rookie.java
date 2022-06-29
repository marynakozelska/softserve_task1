package com.task;

public class Rookie extends Warrior implements canAttack{
    @Override
    public int getAttack() {
        return 1;
    }
}

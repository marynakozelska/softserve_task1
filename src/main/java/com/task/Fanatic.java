package com.task;

public class Fanatic extends Warrior {
    private static final int ATTACK_DEFAULT = 10;

    public Fanatic() {
        super();
        this.gainedAttack = ATTACK_DEFAULT;
    }

    @Override
    public void hits(Warrior enemy) {
        super.hits(enemy);
        setHealth(0);
    }
}

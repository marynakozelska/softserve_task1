package com.task;

public class Healer extends Warrior {
    private static final int ATTACK = 0;
    private static final int HEALING = 2;

    public Healer() {
        super(60);
    }

    public int getAttack() {
        return ATTACK;
    }

    public void heal(Warrior warriorInTheFront) {
        warriorInTheFront.setHealth(Math.min(warriorInTheFront.getInitialHealth(),
                warriorInTheFront.getHealth() + HEALING));
    }
}

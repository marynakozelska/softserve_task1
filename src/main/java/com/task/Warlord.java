package com.task;

public class Warlord extends Defender {
    public static final int HEALTH_DEFAULT = 100;
    public static final int ATTACK_DEFAULT = 4;
    public static final int DEFENSE_DEFAULT = 2;

    public Warlord() {
        super(HEALTH_DEFAULT, ATTACK_DEFAULT, DEFENSE_DEFAULT);
    }

    public void rearrangeArmy(Army army) {
        army.moveUnits();
    }
}

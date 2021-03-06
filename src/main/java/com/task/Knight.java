package com.task;

public class Knight extends Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 7;
    //private int gainedAttack = 7;


    public Knight() {
        super();
        this.gainedAttack = ATTACK_DEFAULT;
    }

    @Override
    public int getAttack() {
        return gainedAttack;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setMaxHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setHealth(getMaxHealth());
        this.gainedAttack += weapon.getAttack();
    }
}

package com.task;

public class Vampire extends Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 4;
    private static final int VAMPIRISM_DEFAULT = 50;
    private int gainedVampirism = VAMPIRISM_DEFAULT;

    public Vampire() {
        super(40);
        this.gainedAttack = ATTACK_DEFAULT;
    }

    public int getVampirism() {
        return gainedVampirism;
    }

    @Override
    public void hits(Warrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damage = healthBefore - enemy.getHealth();
//        setHealth(Math.min(getMaxHealth(), getHealth() + damage * getVampirism() / 100));
        setHealth(getHealth() + damage * getVampirism() / 100);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setMaxHealth(getHealth());
        this.gainedAttack += weapon.getAttack();
        this.gainedVampirism += weapon.getVampirism();
    }
}
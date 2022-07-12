package com.task;

public class Defender extends Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 3;
    private static final int DEFENSE_DEFAULT = 2;
    protected int gainedDefense = DEFENSE_DEFAULT;

    public Defender() {
        super(60, ATTACK_DEFAULT);
        setDefense(DEFENSE_DEFAULT);
    }

    public Defender(int health, int attack, int gainedDefense) {
        super(health);
        setAttack(attack);
        setDefense(gainedDefense);
    }

    public int getDefense() {
        return gainedDefense;
    }

    public void setDefense(int defense) {
        this.gainedDefense = defense;
    }

    @Override
    public void getHitBy(CanAttack enemy) {
        int dealtDamage =
                Math.max(
                        0,
                        enemy.getAttack() - getDefense()
                );
        setHealth(Math.max(0, getHealth() - dealtDamage));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setMaxHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setHealth(getMaxHealth());
        setAttack(getAttack() + weapon.getAttack());
        setDefense(Math.max(0, getDefense() + weapon.getDefense()));
    }
}

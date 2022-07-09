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
    public void getHitBy(Warrior enemy) {
        if (enemy.getAttack() != 0) setHealth(Math.max(0, getHealth() - enemy.getAttack() + getDefense()));

        if (getWarriorBehind() instanceof Healer && this.getHealth() != 0) {
            Healer healer = (Healer) getWarriorBehind();
            healer.heal(this);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setAttack(getAttack() + weapon.getAttack());
        setDefense(Math.max(0, getDefense() + weapon.getDefense()));
    }
}

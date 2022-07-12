package com.task;

public class Lancer extends Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 6;
    private static final int LANCER_POWER = 50;

    public Lancer() {
        super(50, ATTACK_DEFAULT);
    }

    @Override
    public void hits(Warrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damageForFirstEnemy = healthBefore - enemy.getHealth();
        Warrior warriorBehind = enemy.getWarriorBehind();
        if (warriorBehind != null && warriorBehind != this) {
            warriorBehind.setHealth(Math.max(0, warriorBehind.getHealth() - damageForFirstEnemy * LANCER_POWER / 100));
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setMaxHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setHealth(getMaxHealth());
        this.gainedAttack += weapon.getAttack();
    }
}

package com.task;

public class Lancer extends Warrior {
    private static final int ATTACK = 6;
    private static final int LANCER_POWER = 50;

    public Lancer() {
        super(50);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hits(Warrior enemy) {
        int healthBefore = enemy.getHealth();
        super.hits(enemy);
        int damageForFirstEnemy = healthBefore - enemy.getHealth();
        Warrior warriorBehind = enemy.getWarriorBehind();
        if (warriorBehind != null) {
            warriorBehind.setHealth(warriorBehind.getHealth() - damageForFirstEnemy * LANCER_POWER / 100);
        }
    }

}

package com.task;

public class Healer extends Warrior implements CanAttack {
    private static final int ATTACK_DEFAULT = 0;
    private static final int HEALING_POWER = 2;
    private int gainedHealingPower = HEALING_POWER;

    public Healer() {
        super(60);
        this.gainedAttack = ATTACK_DEFAULT;
    }

    public int getHealingPower() {
        return gainedHealingPower;
    }

    public void heal(Warrior warriorInTheFront) {
        if (warriorInTheFront.getHealth() > 0) {
            warriorInTheFront.setHealth(
                    Math.min(warriorInTheFront.getMaxHealth(),
                            warriorInTheFront.getHealth() + gainedHealingPower
                    )
            );
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setMaxHealth(Math.max(0, getHealth() + weapon.getHealth()));
        setHealth(getMaxHealth());
        this.gainedHealingPower += weapon.getHealPower();
    }

    @Override
    public void process(Warrior warrior, Warrior previousWarrior) {
        if (previousWarrior != null) this.heal(previousWarrior);
        super.process(warrior, previousWarrior);
    }
}

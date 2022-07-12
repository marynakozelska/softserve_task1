package com.task;

import java.util.Optional;

public class Witch extends Warrior {
    private static final int ATTACK_DEFAULT = 5;
    private static final int ENCHANTMENT_POWER_DEFAULT = 10;
    private int enchantmentIterator = 1;
    private int enchantmentPower;
    boolean attacked = false;

    public Witch() {
        super();
        this.gainedAttack = ATTACK_DEFAULT;
        this.enchantmentPower = ENCHANTMENT_POWER_DEFAULT;
    }

    @Override
    public void hits(Warrior enemy) {
        if (!attacked) {
            attacked = true;
            superAttack(enemy);
        } else if (enchantmentPower == ENCHANTMENT_POWER_DEFAULT &&
                !(enemy instanceof Vampire) &&
                !(enemy instanceof Witch) &&
                (enemy.getWarriorBehind() != null || enemy.getWarriorOnTheRight() != null || enemy.getWarriorOnTheLeft() != null)) {
            System.out.printf("[%s] I enchanted my enemy!\n", this.getClass());
            enchants(enemy);
        } else {
            super.hits(enemy);
            enchantmentPower += enchantmentIterator;
        }
    }

    public void enchants(Warrior enemy) {
        if (enemy.getWarriorBehind() != null) Battle.fight(enemy, enemy.getWarriorBehind());
        else if (enemy.getWarriorOnTheRight() != null) Battle.fight(enemy, enemy.getWarriorOnTheRight());
        else if (enemy.getWarriorOnTheLeft() != null) Battle.fight(enemy, enemy.getWarriorOnTheLeft());
        enchantmentPower = 0;
    }

    public void superAttack(Warrior enemy) {
        super.hits(enemy);
        if (enemy.getWarriorBehind() != null) {
            super.hits(enemy.getWarriorBehind());
            if (enemy.getWarriorBehind().getWarriorBehind() != null)
                super.hits(enemy.getWarriorBehind().getWarriorBehind());
        } else {
            if (enemy.getWarriorOnTheRight() != null) super.hits(enemy.getWarriorOnTheRight());
            if (enemy.getWarriorOnTheLeft() != null) super.hits(enemy.getWarriorOnTheLeft());
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.enchantmentIterator += weapon.getEnchantmentIterator();
    }
}


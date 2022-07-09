package com.task;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Weapon {
    private int health = 0;
    private int attack = 0;
    private int vampirism = 0;
    private int defense = 0;
    private int healPower = 0;

    private static WeaponBuilder swordBuilder = builder()
            .health(5)
            .attack(2);

    private static WeaponBuilder shieldBuilder = builder()
            .health(20)
            .attack(-1)
            .defense(2);

    private static WeaponBuilder greatAxeBuilder = builder()
            .health(-15)
            .attack(5)
            .defense(-2)
            .vampirism(10);

    private static WeaponBuilder katanaBuilder = builder()
            .health(-20)
            .attack(6)
            .defense(-5)
            .vampirism(50);

    private static WeaponBuilder magicWandBuilder = builder()
            .health(30)
            .attack(3)
            .healPower(3);

    public static Weapon getSword() {
        return swordBuilder.build();
    }

    public static Weapon getShield() {
        return shieldBuilder.build();
    }

    public static Weapon getGreatAxe() {
        return greatAxeBuilder.build();
    }

    public static Weapon getKatana() {
        return katanaBuilder.build();
    }

    public static Weapon getMagicWand() {
        return magicWandBuilder.build();
    }

}

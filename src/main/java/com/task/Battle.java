package com.task;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.hits(warrior2);
            if (warrior2.isAlive()) warrior2.hits(warrior1);
        }
        return warrior1.isAlive();
    }

    public static boolean fight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            if (fight(army1.getFirstWarrior(), army2.getFirstWarrior())) {
                army2.removeFirstWarrior();
            } else {
                army1.removeFirstWarrior();
            }
        }
        return army1.isAlive();
    }
}

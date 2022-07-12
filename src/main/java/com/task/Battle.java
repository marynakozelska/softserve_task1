package com.task;

import java.util.Iterator;
import java.util.ListIterator;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        System.out.printf("Attacker health: %d Defender health: %d\n", warrior1.getHealth(), warrior2.getHealth());

        int iterator = 0;
        while (warrior1.isAlive() && warrior2.isAlive()) {
            if (iterator > 100) {
                if (warrior1.getHealth() > warrior2.getHealth()) {
                    warrior2.setHealth(0);
                }
            }

            if (warrior1 instanceof Healer && warrior2 instanceof Healer) { // healers fight
                warrior1.setHealth(0);
                warrior2.setHealth(0);
            } else {
                warrior1.hits(warrior2);
                if (warrior2.isAlive()) warrior2.hits(warrior1);
            }
            iterator++;
        }
        System.out.println();
        System.out.printf("[%s] health = %d\n", warrior1.getClass(), warrior1.getHealth());
        System.out.printf("[%s] health = %d\n", warrior2.getClass(), warrior2.getHealth());
        System.out.println("____________________________________________________");
        return warrior1.isAlive();
    }

    public static boolean fight(Army army1, Army army2) {

        while (army1.isAlive() && army2.isAlive()) {
            if (fight(army1.getFirstWarrior(), army2.getFirstWarrior())) {
                army2.removeFirstWarrior();
            } else {
                army1.removeFirstWarrior();
            }
//            System.out.println("\nAFTER ROUND:\n");
            if (army1.hasWarlord) rearrangingArmy(army1);
            if (army2.hasWarlord) rearrangingArmy(army2);

        }
        return army1.isAlive();
    }

    private static void rearrangingArmy(Army army) {
        if (!army.isAlive()) return;
        Warlord warlord = new Warlord();
        for (int i = 0; i < army.getTroops().size(); i++) {
            if (army.getWarrior(i) instanceof Warlord) {
                warlord = (Warlord) army.getWarrior(i);
                break;
            }
        }
        warlord.rearrangeArmy(army);
    }


    public static boolean straightFight(Army army1, Army army2) {
        Army temporaryArmy1 = new Army();
        Army temporaryArmy2 = new Army();

        for (int i = 0; i < army1.getTroops().size(); i++) {
            temporaryArmy1.addToLine(army1.getWarrior(i));
        }
        for (int i = 0; i < army2.getTroops().size(); i++) {
            temporaryArmy2.addToLine(army2.getWarrior(i));
        }

        while (temporaryArmy1.isAlive() && temporaryArmy2.isAlive()) {
            Iterator<Warrior> iterator1 = temporaryArmy1.iterator();
            Iterator<Warrior> iterator2 = temporaryArmy2.iterator();

            while (iterator1.hasNext() && iterator2.hasNext()) {
                Battle.fight(iterator1.next(), iterator2.next());
            }
        }

        army1.removeAllWarriors();
        army2.removeAllWarriors();

        for (int i = 0; i < temporaryArmy1.getTroops().size(); i++) {
            army1.addToColumn(temporaryArmy1.getWarrior(i));
        }
        for (int i = 0; i < temporaryArmy2.getTroops().size(); i++) {
            army2.addToColumn(temporaryArmy2.getWarrior(i));
        }

        return army1.isAlive();
    }
}

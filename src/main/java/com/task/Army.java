package com.task;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Supplier;

public class Army {
    private LinkedList<Warrior> troops = new LinkedList<>();

    public void addUnits(Supplier<Warrior> inputTroops, int count) {
        for (int i = 0; i < count; i++) {
            troops.add(inputTroops.get());
        }
    }

    public void addUnits(Warrior inputWarrior) {
        troops.add(inputWarrior);
    }

    public Collection<Warrior> getTroops() {
        return troops;
    }

    public boolean isAlive() {
        return !troops.isEmpty();
    }

    public Warrior getFirstWarrior() {
        return troops.getFirst();
    }

    public void removeFirstWarrior() {
        troops.removeFirst();
    }

}
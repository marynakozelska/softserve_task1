package com.task;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    private LinkedList<Warrior> troops = new LinkedList<>();

    public void addUnits(Supplier<Warrior> inputTroops, int count) {
        for (int i = 0; i < count; i++) {
            Warrior previousWarrior = inputTroops.get();
            if (!troops.isEmpty()) {
                troops.get(troops.size() - 1).setWarriorBehind(previousWarrior);
            }
            troops.add(previousWarrior);
        }
    }

//    public void addUnits(Warrior inputWarrior) {
//        troops.add(inputWarrior);
//    }

    public void addToColumn(Warrior warrior) {
        if (!troops.isEmpty()) {
            troops.get(troops.size() - 1).setWarriorBehind(warrior);
        }
        troops.add(warrior);
    }

    public void addToLine(Warrior warrior) {     //  with no one behind
        warrior.setWarriorBehind(null);
        troops.add(warrior);
    }

    public Collection<Warrior> getTroops() {
        return Collections.unmodifiableList(troops);
    }

    public boolean isAlive() {
        if (isEmpty()) return false;
        for (Warrior troop : troops) {
            if (troop.isAlive()) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return troops.isEmpty();
    }

    public Warrior getFirstWarrior() {
        return troops.getFirst();
    }

    public Warrior getWarrior(int index) {
        return troops.get(index);
    }

    public void removeFirstWarrior() {
        troops.removeFirst();
    }

    public void removeWarrior(int index) {
        troops.remove(index);
    }

    public void removeAllWarriors() {
        for (int i = 0; i < troops.size(); i++) {
            removeWarrior(i);
        }
    }

    @Override
    public Iterator<Warrior> iterator() {
        return new TroopsIterator();
    }

    class TroopsIterator implements Iterator<Warrior> {
        int index = 0;

        @Override
        public boolean hasNext() {
            while (index < troops.size() && !troops.get(index).isAlive()) {
                index++;
            }
            return index < troops.size();
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return troops.get(index++);
            }
        }
    }
}
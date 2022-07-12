package com.task;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    private LinkedList<Warrior> troops = new LinkedList<>();
    boolean hasWarlord = false;

    public void addUnits(Supplier<Warrior> inputTroops, int count) {
        for (int i = 0; i < count; i++) {
            if (hasWarlord && inputTroops.get() instanceof Warlord) continue;
            if (inputTroops.get() instanceof Warlord) hasWarlord = true;

            Warrior previousWarrior = inputTroops.get();
            if (!troops.isEmpty()) {
                troops.get(troops.size() - 1).setWarriorBehind(previousWarrior);
            }
            troops.add(previousWarrior);
        }
    }

    public void addUnits(Warrior inputWarrior) {
        if (!troops.isEmpty()) {
            troops.get(troops.size() - 1).setWarriorBehind(inputWarrior);
        }
        troops.add(inputWarrior);
    }

    public void addToColumn(Warrior warrior) {
        if (!troops.isEmpty()) {
            troops.get(troops.size() - 1).setWarriorBehind(warrior);
        }
        troops.add(warrior);
    }

    public void addToLine(Warrior warrior) {     //  with no one behind
        warrior.setWarriorBehind(null);
        if (troops.size() != 0) {
            troops.get(troops.size() - 1).setWarriorOnTheRight(warrior);
            warrior.setWarriorOnTheLeft(troops.get(troops.size() - 1));
        }
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
        if (troops.getFirst() instanceof Warlord) hasWarlord = false;
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

    public void equipWarriorAtPosition(int position, Weapon weapon) {
        troops.get(position).equipWeapon(weapon);
    }

    public void moveUnits() {
        if (hasWarlord) {
            Army temporaryTroops = new Army();

            boolean firstSoliderStands = setFirstUnit(temporaryTroops);
            Warrior temporaryWarlord = null;

//            find warlord
            temporaryWarlord = findWarlord();
            temporaryWarlord.setWarriorBehind(null);
            if (!firstSoliderStands) {
                temporaryTroops.addUnits(temporaryWarlord);
            }

//            adding healers
            for (int i = 0; i < troops.size(); i++) {
                if (troops.get(i) instanceof Healer) {
                    temporaryTroops.addUnits(troops.get(i));
                    troops.remove(i);   // moves list
                    i--;
                }
            }
//            adding more lancers
            for (int i = 0; i < troops.size() && firstSoliderStands; i++) {
                if (troops.get(i) instanceof Lancer) {
                    temporaryTroops.addUnits(troops.get(i));
                    troops.remove(i);
                    i--;
                }
            }

//            adding everyone else
            for (int i = 0; i < troops.size(); i++) {
                temporaryTroops.addUnits(troops.get(i));
                troops.remove(i);   // moves list
                i--;
            }
            troops.clear();

            if (firstSoliderStands) {
                temporaryTroops.addUnits(temporaryWarlord);
            } else {
                temporaryTroops.getWarrior(temporaryTroops.size() - 1).setWarriorBehind(null);
            }

            troops.addAll(temporaryTroops.troops);
        }

        printRearranged(troops);
    }

    private void printRearranged(LinkedList<Warrior> troops) {
        System.out.println("\n__________________________________________________");
        for (Warrior troop : troops) {
            System.out.println(troop + " Current health: " + troop.getHealth());
        }
        System.out.println("__________________________________________________\n");
    }

    private boolean setFirstUnit(Army temporaryArmy) {
        boolean flag = false;
//            setting first lancer
        for (int i = 0; i < troops.size(); i++) {
            if (troops.get(i) instanceof Lancer) {
                temporaryArmy.addUnits(troops.get(i));
                troops.remove(i);
                flag = true;
                break;
            }
        }
//            if no lancer added
        if (temporaryArmy.isEmpty()) {
            for (int i = 0; i < troops.size(); i++) {
                if (!(troops.get(i) instanceof Healer) && !(troops.get(i) instanceof Warlord)) {
                    temporaryArmy.addUnits(troops.get(i));
                    troops.remove(i);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public Warrior unitAtPosition(int position) {
        if (position < 0) return troops.get(troops.size() + position);
        return troops.get(position);
    }

    public int size() {
        return troops.size();
    }

    private Warlord findWarlord() {
        Warlord warlord = null;
        for (int i = 0; i < troops.size(); i++) {
            if (troops.get(i) instanceof Warlord) {
                warlord = (Warlord) troops.get(i);
                troops.remove(i);
                break;
            }
        }
        return warlord;
    }
}
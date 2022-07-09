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
            LinkedList<Warrior> temporaryTroops = new LinkedList<>();

            boolean firstSoliderStands = setFirstUnit(temporaryTroops);
            Warrior temporaryWarlord = null;

//            find warlord
            temporaryWarlord = findWarlord(temporaryTroops);
            if (!firstSoliderStands) {
                temporaryTroops.add(temporaryWarlord);
            }

//            adding healers
            for (int i = 0; i < troops.size(); i++) {
                if (troops.get(i) instanceof Healer) {
                    temporaryTroops.add(troops.get(i));
                    troops.remove(i);   // moves list
                    i--;
                }
            }
//            adding more lancers
            for (int i = 0; i < troops.size() && firstSoliderStands; i++) {
                if (troops.get(i) instanceof Lancer) {
                    temporaryTroops.add(troops.get(i));
                    troops.remove(i);
                    i--;
                }
            }

//            adding everyone else
            temporaryTroops.addAll(troops);
            troops.clear();
            if (firstSoliderStands) temporaryTroops.add(temporaryWarlord);

            troops.addAll(temporaryTroops);
        }
    }

    private boolean setFirstUnit(LinkedList<Warrior> temporaryArmy) {
        boolean flag = false;
//            setting first lancer
        for (int i = 0; i < troops.size(); i++) {
            if (troops.get(i) instanceof Lancer) {
                temporaryArmy.add(troops.get(i));
                troops.remove(i);
                flag = true;
                break;
            }
        }
//            if no lancer added
        if (temporaryArmy.isEmpty()) {
            for (int i = 0; i < troops.size(); i++) {
                if (!(troops.get(i) instanceof Healer) && !(troops.get(i) instanceof Warlord)) {
                    temporaryArmy.add(troops.get(i));
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

    private Warlord findWarlord(LinkedList<Warrior> temporaryArmy) {
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
package com.task;

public abstract class HealingProcessor {
    public void process(Warrior warrior, Warrior previousWarrior) {
        if (warrior.getWarriorBehind() != null) {
            warrior.getWarriorBehind().process(warrior.getWarriorBehind(),
                    warrior);
        }
    }
}

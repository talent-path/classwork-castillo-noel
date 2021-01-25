package com.tp.rpg.armors;

public class Robe implements Armor {

    int defense = 5;

    public int reduceDamage(int startingDamage) {

        return startingDamage - defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
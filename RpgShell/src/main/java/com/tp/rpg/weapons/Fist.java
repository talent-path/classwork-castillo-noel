package com.tp.rpg.weapons;

public class Fist implements Weapon {

    int attack = 5;

    public int generateDamage() {

        return 5;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

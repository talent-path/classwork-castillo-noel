package com.tp.rpg.weapons;

public class Sword implements Weapon {

    int attack = 20;

    public int generateDamage() {

        return 20;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

package com.tp.rpg.weapons;

public class DragonClaw implements Weapon {

    int attack = 75;

    public int generateDamage() {

        return attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
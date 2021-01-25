package com.tp.rpg.weapons;

public class Bow  implements Weapon {

    int attack = 15;

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

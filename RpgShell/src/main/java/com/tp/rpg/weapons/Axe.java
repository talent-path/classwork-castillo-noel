package com.tp.rpg.weapons;

public class Axe  implements Weapon {

    int attack = 25;

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

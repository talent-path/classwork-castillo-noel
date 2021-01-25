package com.tp.rpg.weapons;

public class Dagger  implements Weapon {

    int attack = 10;

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

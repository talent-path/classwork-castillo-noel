package com.tp.rpg;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)

import com.tp.rpg.armors.Armor;
import com.tp.rpg.weapons.Weapon;

//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser {

    // V A R I A B L E S

    public int hp = 100;

    public int magicLvl = 0;

    public Armor armor;

    public Weapon weapon;

    public String name;

    // C O N S T R U C T O R S
    public Character() {

    }

    public Character(String name) {
        this.name = name;
    }


    // M E T H O D S
    //TODO: add fields for armor(s) and weapon(s)

    public Character attack(Character defender) {

        defender.setHp(defender.getHp() - (defender.getArmor().reduceDamage(this.weapon.generateDamage())));

        return defender;
    }

    public void takeDamage(int damage) {
        this.hp = this.hp - damage;
    }

    public boolean isAlive() {

        return this.hp > 0 ? true : false;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

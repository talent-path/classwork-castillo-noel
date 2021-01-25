package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.items.Item;
import com.tp.rpg.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter extends Character {
    //use scanner here to get something from the user

    //V A R I A B L E S

    public Map<Item, Integer> items = new HashMap<>();

    //C O N S T R U C T O R
    public PlayerCharacter(String name){
        this.name = name;
        this.hp = 100;
    }

    public PlayerCharacter(String name, Weapon weapon, Armor armor){
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
    }

    // M E T H O D S
    public String makeChoice() {

        throw new UnsupportedOperationException();
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }
}

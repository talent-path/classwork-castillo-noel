package com.tp.rpg.enemies;

import com.tp.rpg.NonPlayerCharacter;
import com.tp.rpg.armors.DragonScale;
import com.tp.rpg.armors.Leather;
import com.tp.rpg.weapons.Dagger;
import com.tp.rpg.weapons.DragonClaw;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {

    // C O N S T R U C T O R S
    public Goblin(){
        this.hp = 25;
        this.armor = new Leather();
        this.weapon = new Dagger();
    }

    public String makeChoice() {
        return "attack";
    }
}

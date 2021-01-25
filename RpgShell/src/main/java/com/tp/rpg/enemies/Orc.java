package com.tp.rpg.enemies;

import com.tp.rpg.NonPlayerCharacter;
import com.tp.rpg.armors.Chainmail;
import com.tp.rpg.armors.DragonScale;
import com.tp.rpg.weapons.DragonClaw;
import com.tp.rpg.weapons.Sword;

public class Orc extends NonPlayerCharacter {

    // C O N S T R U C T O R S
    public Orc(){
        this.hp = 100;
        this.armor = new Chainmail();
        this.weapon = new Sword();
    }

    public String makeChoice() {
        return "attack";
    }
}

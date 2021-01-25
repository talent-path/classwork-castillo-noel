package com.tp.rpg.enemies;

import com.tp.rpg.NonPlayerCharacter;
import com.tp.rpg.armors.DragonScale;
import com.tp.rpg.weapons.DragonClaw;

public class Dragon extends NonPlayerCharacter {

    // C O N S T R U C T O R S
    public Dragon(){
        this.hp = 1000;
        this.armor = new DragonScale();
        this.weapon = new DragonClaw();
    }

    // M E T H O D S
    public String makeChoice() {
        return "attack";
    }
}

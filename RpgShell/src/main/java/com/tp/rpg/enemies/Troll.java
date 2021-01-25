package com.tp.rpg.enemies;

import com.tp.rpg.NonPlayerCharacter;
import com.tp.rpg.armors.DragonScale;
import com.tp.rpg.armors.Plate;
import com.tp.rpg.weapons.Axe;
import com.tp.rpg.weapons.DragonClaw;

public class Troll extends NonPlayerCharacter {

    // C O N S T R U C T O R S
    public Troll(){
        this.hp = 200;
        this.armor = new Plate();
        this.weapon = new Axe();
    }

    public String makeChoice() {
        return "attack";
    }
}

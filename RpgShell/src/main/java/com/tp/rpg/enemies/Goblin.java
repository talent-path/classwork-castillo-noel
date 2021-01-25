package com.tp.rpg.enemies;

import com.tp.rpg.NonPlayerCharacter;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {

    public String makeChoice() {
        return "attack";
    }
}

package com.tp.rpg.items;

import com.tp.rpg.PlayerCharacter;

public class HealthPotion extends Item{

    public PlayerCharacter heal(PlayerCharacter pc) {
        pc.setHp(pc.getHp() + 40);
        return pc;
    }
}

package com.tp.rpg.items;

import com.tp.rpg.PlayerCharacter;

public class HealthPotion implements Healing{

    public PlayerCharacter heal(PlayerCharacter pc) {
        pc.setHp(pc.getHp() + 40);
        return pc;
    }
}

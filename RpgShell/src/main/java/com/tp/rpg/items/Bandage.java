package com.tp.rpg.items;

import com.tp.rpg.PlayerCharacter;

public class Bandage implements Healing{

    public PlayerCharacter heal(PlayerCharacter pc) {
        pc.setHp(pc.getHp() + 15);
        return pc;
    }
}

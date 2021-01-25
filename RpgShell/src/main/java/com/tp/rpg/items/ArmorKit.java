package com.tp.rpg.items;

import com.tp.rpg.PlayerCharacter;

public class ArmorKit {

    public PlayerCharacter improveArmor(PlayerCharacter pc) {
        pc.getArmor().setDefense(pc.getArmor().getDefense() + 10);
        return pc;
    }
}

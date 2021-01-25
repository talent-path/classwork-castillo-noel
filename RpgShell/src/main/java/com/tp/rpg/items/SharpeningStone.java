package com.tp.rpg.items;

import com.tp.rpg.PlayerCharacter;

public class SharpeningStone extends Item{

    public PlayerCharacter sharpenWeapon(PlayerCharacter pc) {
        pc.getWeapon().setAttack(pc.getWeapon().getAttack() + 10);
        return pc;
    }
}

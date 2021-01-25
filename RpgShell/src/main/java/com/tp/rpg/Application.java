package com.tp.rpg;

import com.tp.rpg.armors.Chainmail;
import com.tp.rpg.armors.Leather;
import com.tp.rpg.armors.Plate;
import com.tp.rpg.armors.Robe;
import com.tp.rpg.weapons.*;

import java.util.Scanner;



public class Application {
    public static void main(String[] args) {

        PlayerCharacter pc = setUpPlayer();

        while( pc.isAlive() ){
            NonPlayerCharacter enemy = setUpEnemy();

            battle( pc, enemy );

        }

        gameOverScreen();

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        Scanner scn = new Scanner((System.in));
        System.out.println("What is your name traveler?");
        String name = scn.nextLine();
        PlayerCharacter player = new PlayerCharacter(name);
        int weaponSelection = Console.readInt("Select your weapon:\n(1) Axe\n(2) Bow\n(3) Sword\n(4) Dagger",1, 4);
        switch(weaponSelection){
            case 1:
                player.setWeapon(new Axe());
                break;
            case 2:
                player.setWeapon(new Bow());
                break;
            case 3:
                player.setWeapon(new Sword());
                break;
            case 4:
                player.setWeapon(new Dagger());
                break;
        }

        int armorSelection = Console.readInt("Select your armor:\n(1) Robe\n(2) Leather Vest\n(3) Chainmail\n(4) Plate",1, 4);
        switch(armorSelection){
            case 1:
                player.setArmor(new Robe());
                break;
            case 2:
                player.setArmor(new Leather());
                break;
            case 3:
                player.setArmor(new Chainmail());
                break;
            case 4:
                player.setArmor(new Plate());
                break;
        }

        return player;
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {


        throw new UnsupportedOperationException();
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;

        while( a.isAlive() && b.isAlive() ){
            if( a.makeChoice().equals("Attack")) {
                attacker.attack(defender);
            } else {
                //TODO: consider other actions
                throw new UnsupportedOperationException();
            }

            //TODO: display HP status?
            System.out.println(a.getName() + "'s current HP: " + a.getHp());
            System.out.println(b.getName() + "'s current HP: " + b.getHp());
            Character temp = a;
            a = b;
            b = temp;
        }
    }

    //display some message
    private static void gameOverScreen() {
    }
}

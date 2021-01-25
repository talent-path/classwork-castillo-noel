package com.tp.rpg;

import com.tp.rpg.armors.Chainmail;
import com.tp.rpg.armors.Leather;
import com.tp.rpg.armors.Plate;
import com.tp.rpg.armors.Robe;
import com.tp.rpg.enemies.Dragon;
import com.tp.rpg.enemies.Goblin;
import com.tp.rpg.enemies.Orc;
import com.tp.rpg.enemies.Troll;
import com.tp.rpg.items.*;
import com.tp.rpg.weapons.*;

import java.util.*;




public class Application {

    // V A R I A B L E S
    public static int dragonsDefeated = 0;
    public static int trollsDefeated = 0;
    public static int orcsDefeated = 0;
    public static int goblinsDefeated = 0;

    // M A I N
    public static void main(String[] args) {
        PlayerCharacter pc = setUpPlayer();

        while (pc.isAlive() && dragonsDefeated == 0) {
            NonPlayerCharacter enemy = setUpEnemy();

            battle(pc, enemy);
            if(pc.isAlive()){
                if(enemy.getClass().equals("class Dragon")) {
                    dragonsDefeated++;
                } else if(enemy.getClass().equals("class Troll")){
                    trollsDefeated++;
                } else if(enemy.getClass().equals("class Orc")){
                    orcsDefeated++;
                } else{
                    goblinsDefeated++;
                }
            }

        }

        gameOverScreen();

    }

    // M E T H O D S

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        Scanner scn = new Scanner((System.in));
        System.out.println("What is your name traveler?");
        String name = scn.nextLine();
        PlayerCharacter player = new PlayerCharacter(name);
        int weaponSelection = Console.readInt("Select your weapon:\n(1) Axe\n(2) Bow\n(3) Sword\n(4) Dagger", 1, 4);
        switch (weaponSelection) {
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

        int armorSelection = Console.readInt("Select your armor:\n(1) Robe\n(2) Leather Vest\n(3) Chainmail\n(4) Plate", 1, 4);
        switch (armorSelection) {
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

        player.getItems().put(new ArmorKit(), 1);
        player.getItems().put(new Bandage(), 1);
        player.getItems().put(new HealthPotion(), 1);
        player.getItems().put(new SharpeningStone(), 1);
        return player;
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        Random rng = new Random();
        int enemyRng = rng.nextInt(11);
        if(enemyRng < 5){
            return new Goblin();
        } else if(enemyRng >= 5 && enemyRng <= 7){
            return new Orc();
        } else if(enemyRng > 7 && enemyRng < 10){
            return new Troll();
        } else{
            return new Dragon();
        }
    }

    //a and b battle until one is dead
    private static PlayerCharacter battle(PlayerCharacter pc, NonPlayerCharacter enemy) {

        boolean pcTurn = true;
        int battleSelection = Console.readInt("Select your weapon:" +
                "\n(1) Axe\n(2) Bow\n(3) Sword\n(4) Dagger", 1, 4);

        while (pc.isAlive() && enemy.isAlive()) {
            if (pc.makeChoice().equals("Attack")) {
                pc.attack(enemy);
            } else if(pc.makeChoice().equals("Use Item")){
                //TODO: consider other actions
                throw new UnsupportedOperationException();
            } else {
                System.out.println(pc.getName() + " decides to run away!");
                break;
            }

            //TODO: display HP status?
            System.out.println(pc.getName() + "'s current HP: " + pc.getHp());
            System.out.println(enemy.getName() + "'s current HP: " + enemy.getHp());
        }

        return pc;
    }

    //display some message
    private static void gameOverScreen() {
        if(dragonsDefeated == 0){
            System.out.println("Your life has been lost in the forest...");
        } else {
            System.out.println("You've slain the Dragon and left the forest as a Hero!");
        }
    }

    public static int getDragonsDefeated() {
        return dragonsDefeated;
    }

    public static void setDragonsDefeated(int dragonsDefeated) {
        Application.dragonsDefeated = dragonsDefeated;
    }

    public static int getTrollsDefeated() {
        return trollsDefeated;
    }

    public static void setTrollsDefeated(int trollsDefeated) {
        Application.trollsDefeated = trollsDefeated;
    }

    public static int getOrcsDefeated() {
        return orcsDefeated;
    }

    public static void setOrcsDefeated(int orcsDefeated) {
        Application.orcsDefeated = orcsDefeated;
    }

    public static int getGoblinsDefeated() {
        return goblinsDefeated;
    }

    public static void setGoblinsDefeated(int goblinsDefeated) {
        Application.goblinsDefeated = goblinsDefeated;
    }
}

package com.tp.diceroller.services;

import java.util.Random;

public class Rng {

    static Random rng = new Random();

    public static int rollDice(int numOfSides){
        return rng.nextInt(numOfSides) + 1;
    }
}

package com.tp.connectfour.model;

import java.util.Random;

public class Rng {

    static Random random=new Random();

    public static int randInt(Integer maxIndexinc){

        return random.nextInt(maxIndexinc+1);

    }

    public static boolean coinFlip(){

        return random.nextBoolean();
    }
}

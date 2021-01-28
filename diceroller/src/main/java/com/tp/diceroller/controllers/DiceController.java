package com.tp.diceroller.controllers;

import com.tp.diceroller.services.Rng;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/helloWorld")
    public String helloWorld(){

        return "Hello World!";
    }

    @GetMapping("/six-die")
    public int rollSixDie(){
        return Rng.rollDice(6);
    }

    @GetMapping("/n-die")
    public int rollDie(Integer n){
        return Rng.rollDice(n);
    }

    @GetMapping("/n-die/{n}")
    public int rollDieV2(@PathVariable Integer n){
        return Rng.rollDice(n);
    }

}

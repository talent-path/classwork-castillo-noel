package com.tp.connectfour.controller;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
import com.tp.connectfour.service.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConntectFourController {
    @Autowired
    ConnectFourService service;
    @GetMapping("/game/{gameId}")
    public ConnectFourBoard getGameById(@PathVariable Integer gameId)throws InvalidGameIdException {
        return service.getGameById(gameId);


    }
    @GetMapping("/games")
    public List<ConnectFourBoard> getAllGames(){
        return service.getAllGames();
    }

    @PostMapping("/start")
    public ConnectFourBoard startGame(){
        return service.startGame();
    }

    @DeleteMapping("delete/{gameId}")
    public String deleteGame(@PathVariable Integer gameId) throws InvalidGameIdException{
        service.deleteGame(gameId);
        return "Game " + gameId + "deleted";
    }
    @PutMapping("/game/{gameId}/{location}")
    public ConnectFourBoard makeMove(@PathVariable Integer gameId,@PathVariable Integer location) throws InvalidGameIdException, ColunmOutOfBoundsException {

       return service.makeMove(service.getGameById(gameId), location);

    }
}

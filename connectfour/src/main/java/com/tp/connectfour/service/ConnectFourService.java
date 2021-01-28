package com.tp.connectfour.service;

import com.tp.connectfour.persistence.ConnectFourinMemDAO;
import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectFourService {

    @Autowired
    ConnectFourinMemDAO dao;

    public ConnectFourBoard getGameById(Integer gameId) throws InvalidGameIdException {
        return dao.getGameById(gameId);
    }

    public List<ConnectFourBoard> getAllGames() {
        return dao.getAllGames();
    }

    public ConnectFourBoard startGame() {
        return dao.startGame();
    }


    public void deleteGame(Integer gameId) throws InvalidGameIdException {
         dao.deleteGame(gameId);
    }
    public ConnectFourBoard makeMove(ConnectFourBoard board,Integer col) throws ColunmOutOfBoundsException {

        return dao.makeMove(board, col);
    }

}

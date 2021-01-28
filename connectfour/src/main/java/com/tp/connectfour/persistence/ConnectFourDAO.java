package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;

import java.util.List;

public interface ConnectFourDAO {

    ConnectFourBoard getGameById(Integer gameId) throws InvalidGameIdException;
    List<ConnectFourBoard> getAllGames();
    void deleteGame(Integer gameId) throws InvalidGameIdException;
    ConnectFourBoard startGame();
    ConnectFourBoard makeMove(ConnectFourBoard board,Integer col) throws ColunmOutOfBoundsException;

}

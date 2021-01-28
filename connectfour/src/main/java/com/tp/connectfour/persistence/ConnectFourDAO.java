package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullColumnException;
import com.tp.connectfour.exceptions.NullGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;

import java.util.List;

public interface ConnectFourDAO {

    ConnectFourBoard getGameById(Integer gameId) throws InvalidGameIdException, NullGameIdException;
    List<ConnectFourBoard> getAllGames();
    void deleteGame(Integer gameId) throws InvalidGameIdException;
    ConnectFourBoard startGame();
    ConnectFourBoard makeMove(ConnectFourBoard board,Integer col) throws ColunmOutOfBoundsException, NullColumnException;
    boolean gameOver(ConnectFourBoard board);

}

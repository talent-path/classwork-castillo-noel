package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConnectFourinMemDAO implements ConnectFourDAO{
    List<ConnectFourBoard> allGames=new ArrayList<>();
    Integer id=0;

@Override
    public ConnectFourBoard getGameById(Integer gameId) throws InvalidGameIdException {

        for (ConnectFourBoard board : allGames) {
            if (board.getGameId().equals(gameId)) {

                return board;
            }
        }
        throw new InvalidGameIdException("No Game with " + gameId);
    }
@Override
    public List<ConnectFourBoard> getAllGames() {

        return allGames;
    }
@Override
    public void deleteGame(Integer gameId) throws InvalidGameIdException {
        for(int i=0; i<allGames.size();i++){
            if(allGames.get(i).getGameId().equals(gameId)){
                allGames.remove(i);
                return;
            }
        }
        throw new InvalidGameIdException("Cannot delete Game with id "+ gameId);
    }
@Override
    public ConnectFourBoard startGame() {


        ConnectFourBoard board= new ConnectFourBoard(id++);
        allGames.add(board);
        return board;
    }
@Override
      public ConnectFourBoard makeMove(ConnectFourBoard board,Integer col) throws ColunmOutOfBoundsException {

        if(col>6|| col <0){
            throw new ColunmOutOfBoundsException("Invalid Placement");
        }
          if (board.isPlayerTurn()) {
              for (int i = 0; i < board.getBoard()[col].length;i++){
                  if(board.getBoard()[col][i]==null){
                      board.getBoard()[col][i]=1;
                      break;
                  }
              }
          }else{
              for (int i = 0; i < board.getBoard()[col].length;i++){
                  if(board.getBoard()[col][i]==null){
                      board.getBoard()[col][i]=2;
                      break;
                  }
              }
              //board.getBoard()[col][]=0;
          }
          board.setPlayerTurn(!board.isPlayerTurn());
          return board;
      }

  }




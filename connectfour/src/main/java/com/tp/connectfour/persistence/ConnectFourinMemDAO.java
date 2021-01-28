package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullColumnException;
import com.tp.connectfour.exceptions.NullGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConnectFourinMemDAO implements ConnectFourDAO {
    List<ConnectFourBoard> allGames = new ArrayList<>();
    Integer id = 0;

    @Override
    public ConnectFourBoard getGameById(Integer gameId) throws InvalidGameIdException, NullGameIdException {

        if (gameId == null) {
            throw new NullGameIdException("You cannot retrieve a game with null id.");
        }

        for (ConnectFourBoard board : allGames) {
            if (board.getGameId().equals(gameId)) {

                return board;
            }
        }
        throw new InvalidGameIdException("No Game with " + gameId);
    }

    @Override
    public List<ConnectFourBoard> getAllGames() {

        List<ConnectFourBoard> copyAllGames = new ArrayList<>();
        for (ConnectFourBoard copy : allGames) {
            copyAllGames.add(new ConnectFourBoard(copy));
        }

        return copyAllGames;
    }

    @Override
    public void deleteGame(Integer gameId) throws InvalidGameIdException {
        for (int i = 0; i < allGames.size(); i++) {
            if (allGames.get(i).getGameId().equals(gameId)) {
                allGames.remove(i);
                return;
            }
        }
        throw new InvalidGameIdException("Cannot delete Game with id " + gameId);
    }

    @Override
    public ConnectFourBoard startGame() {


        ConnectFourBoard board = new ConnectFourBoard(id++);
        allGames.add(board);
        return board;
    }

    @Override
    public ConnectFourBoard makeMove(ConnectFourBoard board, Integer col) throws ColunmOutOfBoundsException, NullColumnException {

        if (col == null) {
            throw new NullColumnException("Column is null");
        }

        if (col > 6 || col < 0) {
            throw new ColunmOutOfBoundsException("Invalid Placement");
        }
        if (board.isPlayerTurn()) {
            for (int i = 0; i < board.getBoard()[col].length; i++) {
                if (board.getBoard()[col][i] == 0) {
                    board.getBoard()[col][i] = 1;
                    break;
                }
            }
        } else {
            for (int i = 0; i < board.getBoard()[col].length; i++) {
                if (board.getBoard()[col][i] == 0) {
                    board.getBoard()[col][i] = 2;
                    break;
                }
            }
        }
        board.setPlayerTurn(!board.isPlayerTurn());
        boolean gameOver = gameOver(board);
        board.setGameOver(gameOver);
        return board;
    }

    @Override
    public boolean gameOver(ConnectFourBoard board) {


        //Check for winner: Vertical, Horizontal, or Diagonal win
        int counter1 = 0;
        int counter2 = 0;

        //Horizontal Win
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.getBoard()[i][j] == 1) {
                    counter1++;
                    counter2 = 0;
                } else if (board.getBoard()[i][j] == 2) {
                    counter2++;
                    counter1 = 0;
                } else {
                    counter1 = 0;
                    counter2 = 0;
                }
                if (counter1 == 4) {
                    return true;
                } else if (counter2 == 4) {
                    return true;
                }
            }

        }

        //Vertical Win
        counter1 = 0;
        counter2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.getBoard()[j][i] == 1) {
                    counter1++;
                    counter2 = 0;
                } else if (board.getBoard()[j][i] == 2) {
                    counter2++;
                    counter1 = 0;
                } else {
                    counter1 = 0;
                    counter2 = 0;
                }
                if (counter1 == 4) {
                    return true;
                } else if (counter2 == 4) {
                    return true;
                }
            }
        }

        //Diagonal
        counter1 = 0;
        counter2 = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.getBoard()[j][i] == 1) {
                    counter1++;
                    counter2 = 0;
                    while (counter1 != 0) {
                        if (i < 6 && board.getBoard()[j][i + 1] == 1) {
                            counter1++;
                        } else if (i > 0 && board.getBoard()[j][i - 1] == 1) {
                            counter1++;
                        } else{
                            counter1 = 0;
                        }
                        if (counter1 == 4) {
                            return true;
                        }
                    }

                } else if (board.getBoard()[j][i] == 2) {
                    counter2++;
                    counter1 = 0;
                    while (counter2 != 0) {
                        if (i < 6 && board.getBoard()[j][i + 1] == 1) {
                            counter1++;
                        } else if (i > 0 && board.getBoard()[j][i - 1] == 1) {
                            counter1++;
                        } else{
                            counter1 = 0;
                        }

                        if (counter2 == 4) {
                            return true;
                        }
                    }
                } else {
                    counter1 = 0;
                    counter2 = 0;
                }
                if (counter1 == 4) {
                    return true;
                } else if (counter2 == 4) {
                    return true;
                }
            }

        }


        //Check for full = draw
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.getBoard()[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int evaluateBoard(int[] board) {
        int status = -1;

        //win check
        //Horizontal Win
        for (int row = 0; row < 3; row++) {
            int rowSum = board[row * 3 + 0] + board[row * 3 + 1] + board[row * 3 + 2];
            if (rowSum * rowSum == 9) status = 1;
        }

        // 0 1 2
        // 3 4 5
        // 6 7 8

        //Vertical Win
        for (int col = 0; col < 3; col++) {
            int colSum = board[3 * 0 + col] + board[3 * 1 + col] + board[3 * 2 + col];
            if (colSum * colSum == 9) status = 1;
        }

        //Diagonal Win
        int d1Sum = board[0] + board[4] + board[8];
        int d2Sum = board[6] + board[4] + board[2];

        if (d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9) status = 1;

        return status;
    }


}




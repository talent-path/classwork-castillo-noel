package com.tp.connectfour.model;

public class ConnectFourBoard {
    private Integer gameId;
    private int[][] board;
    boolean playerTurn;
    boolean gameOver;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public ConnectFourBoard(Integer gameId) {
        this.gameId = gameId;
        this.board = new int[7][6];
        this.playerTurn = true;
        this.gameOver = false;
    }

    public ConnectFourBoard(ConnectFourBoard that) {
        this.gameId = that.gameId;
        this.playerTurn = that.playerTurn;
        this.gameOver = that.gameOver;
        this.board = new int[7][6];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                this.board[i][j] = that.board[i][j];
            }
        }
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

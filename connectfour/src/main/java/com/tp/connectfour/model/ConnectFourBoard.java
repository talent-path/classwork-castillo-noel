package com.tp.connectfour.model;

public class ConnectFourBoard {
    private Integer gameId;
    private Integer[][] board;
    boolean playerTurn;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public ConnectFourBoard(Integer gameId) {
        this.gameId = gameId;
        this.board = new Integer[7][6];
        this.playerTurn = true;
    }

    public ConnectFourBoard(ConnectFourBoard that) {
        this.gameId = that.gameId;
        this.playerTurn = that.playerTurn;
        this.board = new Integer[7][6];

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
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

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }
}

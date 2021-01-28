package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.exceptions.NullColumnException;
import com.tp.connectfour.exceptions.NullGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
import com.tp.connectfour.model.Rng;
import com.tp.connectfour.persistence.ConnectFourinMemDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConnectFourInMemDAOTests {

    @Autowired
    ConnectFourinMemDAO toTest;

    //this will run before each @Test method
    @BeforeEach
    public void setup() throws InvalidGameIdException, ColunmOutOfBoundsException {
        List<ConnectFourBoard> allGames = toTest.getAllGames();

        for (ConnectFourBoard toRemove : allGames) {
            toTest.deleteGame(toRemove.getGameId());
        }

        //creates one game with id = 0;
        toTest.startGame();

    }


    @Test
    public void makeMoveTestGoldenPath() {
        try {
            toTest.startGame();
            ConnectFourBoard testBoard = toTest.getGameById(3);

            //Testing the start
            assertEquals(3, testBoard.getGameId());
            assertTrue(testBoard.isPlayerTurn());

            //Testing PLayer 1 Turn
            testBoard = toTest.makeMove(testBoard, 0);
            assertFalse(testBoard.isPlayerTurn());
            assertEquals(1, testBoard.getBoard()[0][0]);

            //Testing Player 2 Turn
            testBoard = toTest.makeMove(testBoard, 0);
            assertTrue(testBoard.isPlayerTurn());
            assertEquals(2, testBoard.getBoard()[0][1]);

        } catch (InvalidGameIdException | ColunmOutOfBoundsException | NullGameIdException | NullColumnException e) {
            fail();
        }

    }

    @Test
    public void getAllGamesTest() {
        assertEquals(1, toTest.getAllGames().size());
    }

    @Test
    public void getGameByIdTestNullGameId() {
        try {
            ConnectFourBoard testBoard = toTest.startGame();
            testBoard = toTest.getGameById(null);
            fail();
        } catch (InvalidGameIdException e) {
            fail();

        } catch (NullGameIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void makeMoveTestNullColumn() {
        try {
            ConnectFourBoard testBoard = toTest.startGame();
            testBoard = toTest.makeMove(testBoard, null);

        } catch (ColunmOutOfBoundsException e) {
            fail();

        } catch (NullColumnException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void makeMoveTestPastUpperBoundColumn() {
        try {
            ConnectFourBoard testBoard = toTest.startGame();
            testBoard = toTest.makeMove(testBoard, Integer.MAX_VALUE);

        } catch (NullColumnException e) {
            fail();

        } catch (ColunmOutOfBoundsException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void makeMoveTestPastLowerBoundColumn() {
        try {
            ConnectFourBoard testBoard = toTest.startGame();
            testBoard = toTest.makeMove(testBoard, Integer.MIN_VALUE);

        } catch (NullColumnException e) {
            fail();

        } catch (ColunmOutOfBoundsException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getGameByIdTestPastUpperBoundGameId() {
        try {
            ConnectFourBoard testBoard = toTest.getGameById(Integer.MAX_VALUE);
        } catch (NullGameIdException e) {
            fail();

        } catch (InvalidGameIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getGameByIdTestPastLowerBoundGameId() {
        try {
            ConnectFourBoard testBoard = toTest.getGameById(Integer.MIN_VALUE);
        } catch (NullGameIdException e) {
            fail();

        } catch (InvalidGameIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void gameOverHorizontalTest() {

        ConnectFourBoard testBoard = toTest.startGame();
        testBoard.getBoard()[0][0] = 1;
        testBoard.getBoard()[1][0] = 1;
        testBoard.getBoard()[2][0] = 1;
        testBoard.getBoard()[3][0] = 1;
        assertTrue(toTest.gameOver(testBoard));

    }

    @Test
    public void gameOverVerticalTest() {

        ConnectFourBoard testBoard = toTest.startGame();
        testBoard.getBoard()[0][0] = 1;
        testBoard.getBoard()[0][1] = 1;
        testBoard.getBoard()[0][2] = 1;
        testBoard.getBoard()[0][3] = 1;
        assertTrue(toTest.gameOver(testBoard));
    }

    @Test
    public void gameOverDrawTest() {

        ConnectFourBoard testBoard = toTest.startGame();
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                testBoard.getBoard()[i][j] = 1;
            }
        }
        assertTrue(toTest.gameOver(testBoard));
    }

}

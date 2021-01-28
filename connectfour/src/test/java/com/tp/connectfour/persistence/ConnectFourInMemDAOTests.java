package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.ColunmOutOfBoundsException;
import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.model.ConnectFourBoard;
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

		for( ConnectFourBoard toRemove : allGames ){
			toTest.deleteGame( toRemove.getGameId() );
		}

		//creates one game with id = 0;
		toTest.startGame();

	}



	@Test
	void contextLoads() {
	}

}

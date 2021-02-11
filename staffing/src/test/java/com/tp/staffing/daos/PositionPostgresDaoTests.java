package com.tp.staffing.daos;


import com.tp.staffing.exceptions.InvalidPositionIdException;
import com.tp.staffing.exceptions.NullPositionIdException;
import com.tp.staffing.model.Position;
import com.tp.staffing.persistence.EmployeePostgresDao;
import com.tp.staffing.persistence.PositionPostgresDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@ActiveProfiles("daoTesting")
class PositionPostgresDaoTests {

    @Autowired
    PositionPostgresDao toTest;

    @Autowired
    JdbcTemplate template;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {

        template.update("TRUNCATE \"Employee\", \"Position\" RESTART IDENTITY;");

//        template.update( "INSERT INTO \"Position\" (\"title\") VALUES ('Server')" );

    }

    @Test
    public void getPositionByIdGoldenPath() {
        try {
            Position positionToAdd = new Position();
            positionToAdd.setTitle("Owner");

            Integer positionId = toTest.newPosition(positionToAdd);
            Position addedPositionToCheck = toTest.getPositionById(1);


            assertEquals(1, addedPositionToCheck.getId());
            assertEquals("Owner", addedPositionToCheck.getTitle());
        } catch (InvalidPositionIdException e) {
            fail();
        }

    }


    @Test
    public void newPositionGoldenPath() {
        try {
            Position positionToAdd = new Position();
            positionToAdd.setTitle("Owner");

            Integer positionId = toTest.newPosition(positionToAdd);
            Position addedPositionToCheck = toTest.getPositionById(1);


            assertEquals(1, addedPositionToCheck.getId());
            assertEquals("Owner", addedPositionToCheck.getTitle());


            List<Position> allPositions = toTest.getPositions();

            assertEquals(1, allPositions.get(0).getId());
            assertEquals("Owner", allPositions.get(0).getTitle());
        } catch (InvalidPositionIdException e) {
            fail();
        }

    }


}

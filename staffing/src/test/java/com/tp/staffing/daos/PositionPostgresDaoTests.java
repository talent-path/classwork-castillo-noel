package com.tp.staffing.daos;


import com.tp.staffing.exceptions.InvalidPositionIdException;
import com.tp.staffing.exceptions.NullPositionIdException;
import com.tp.staffing.model.Employee;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

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

        template.update("INSERT INTO \"Position\" (\"title\") VALUES ('Server')");

    }

    @Test
    public void newPositionGoldenPath() {

        Position positionToAdd = new Position();
        positionToAdd.setTitle("Owner");

        Integer positionId = toTest.addPosition(positionToAdd);
        Position addedPositionToCheck = toTest.getPositionById(2);


        assertEquals(2, addedPositionToCheck.getId());
        assertEquals("Owner", addedPositionToCheck.getTitle());


        List<Position> allPositions = toTest.getPositions();

        assertEquals(2, allPositions.get(1).getId());
        assertEquals("Owner", allPositions.get(1).getTitle());

    }

    @Test
    public void getPositionByIdGoldenPath() {
        Position positionToCheck = toTest.getPositionById(1);

        assertEquals(1, positionToCheck.getId());
        assertEquals("Server", positionToCheck.getTitle());


    }

    @Test
    public void updatePositionGoldenPathTest() {
        Position positionToUpdate = toTest.getPositionById(1);
        positionToUpdate.setTitle("Manager");
        toTest.editPosition(1, positionToUpdate);

        Position updatedPosition = toTest.getPositionById(1);

        assertEquals(1, updatedPosition.getId());
        assertEquals("Manager", updatedPosition.getTitle());

    }

    @Test
    public void deletePositionGoldenPathTest() {

        assertNotNull(toTest.getPositionById(1));
        toTest.deletePosition(1);
        assertNull(toTest.getPositionById(1));

    }


}

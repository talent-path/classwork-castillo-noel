package com.tp.staffing.services;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import com.tp.staffing.service.EmployeeService;
import com.tp.staffing.service.PositionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class PositionServiceTests {

    @Autowired
    PositionService toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {

    }

    @Test
    public void addPositionNullTitleTest() {
        try {
            Position positionToAdd = new Position();
            positionToAdd.setTitle(null);
            toTest.addPosition(positionToAdd);

        } catch(NullPositionTitleException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void addPositionEmptyTitleTest() {
        try {
            Position positionToAdd = new Position();
            positionToAdd.setTitle("");
            toTest.addPosition(positionToAdd);

        } catch(InvalidPositionTitleException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getPositionByIdNullIdTest() {
        try{
            toTest.getPositionById(null);
        } catch(NullPositionIdException e){
            //Nothing done since we want this.
        } catch (Exception e){
            fail();
        }

    }

    @Test
    public void getPositionByIdInvalidUpperBoundIdTest() {
        try{
            toTest.getPositionById(Integer.MAX_VALUE);
        } catch(InvalidPositionIdException e){
            //Nothing done since we want this.
        } catch (Exception e){
            fail();
        }

    }

    @Test
    public void getPositionByIdInvalidLowerBoundIdTest() {
        try{
            toTest.getPositionById(Integer.MIN_VALUE);
        } catch(InvalidPositionIdException e){
            //Nothing done since we want this.
        } catch (Exception e){
            fail();
        }

    }

    @Test
    public void editPositionNullTitleTest() {
        try {
            Position editedPosition = new Position();
            editedPosition.setTitle(null);
            toTest.editPosition(1, editedPosition);

        } catch(NullPositionTitleException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void editPositionEmptyTitleTest() {
        try {
            Position editedPosition = new Position();
            editedPosition.setTitle("");
            toTest.editPosition(1, editedPosition);

        } catch(InvalidPositionTitleException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }




}

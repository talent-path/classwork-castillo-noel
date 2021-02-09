package com.tp.staffer.services;


import com.tp.staffer.exceptions.*;
import com.tp.staffer.model.Employee;
import com.tp.staffer.model.Position;
import com.tp.staffer.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTests {

    @Autowired
    EmployeeService toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {
        try {

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getEmployeeByIdGoldenPath() {
        try {

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

    }

    @Test
    public void newEmployeeGoldenPath() {
        try {

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }




}

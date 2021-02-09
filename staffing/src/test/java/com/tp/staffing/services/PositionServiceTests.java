package com.tp.staffing.services;


import com.tp.staffing.service.EmployeeService;
import com.tp.staffing.service.PositionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class PositionServiceTests {

    @Autowired
    PositionService toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {
        try {

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getPositionByIdGoldenPath() {
        try {

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }

    }

    @Test
    public void newPositionGoldenPath() {
        try {

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }


}

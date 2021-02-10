package com.tp.staffing.daos;


import com.tp.staffing.persistence.PostgresEmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class EmployeePostgresDaoTests {

    @Autowired
    PostgresEmployeeDao toTest;

    @Autowired
    JdbcTemplate template;


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

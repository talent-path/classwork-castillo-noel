package com.tp.staffing.daos;


import com.tp.staffing.persistence.EmployeePostgresDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@ActiveProfiles("daoTesting")
class EmployeePostgresDaoTests {

    @Autowired
    EmployeePostgresDao toTest;

    @Autowired
    JdbcTemplate template;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {

        template.update("TRUNCATE \"Employee\", \"Position\" RESTART IDENTITY;");

        template.update( "INSERT INTO \"Position\" (\"title\") VALUES ('Server')" );

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

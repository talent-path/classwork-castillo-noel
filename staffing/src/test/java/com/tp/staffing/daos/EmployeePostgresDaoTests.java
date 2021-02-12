package com.tp.staffing.daos;


import com.tp.staffing.exceptions.InvalidEmployeeIdException;
import com.tp.staffing.exceptions.InvalidPositionIdException;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import com.tp.staffing.persistence.EmployeePostgresDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

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

        template.update("INSERT INTO \"Employee\" (\"firstName\", \"lastName\") VALUES ('Noel', 'Castillo')");

    }

    @Test
    public void newEmployeeGoldenPathTest() {
        try {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setFirstName("Joe");
            employeeToAdd.setLastName("Schmo");

            Integer positionId = toTest.addEmployee(employeeToAdd);
            Employee addedEmployeeToCheck = toTest.getEmployeeById(2);


            assertEquals(2, addedEmployeeToCheck.getId());
            assertEquals("Joe", addedEmployeeToCheck.getFirstName());
            assertEquals("Schmo", addedEmployeeToCheck.getLastName());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getEmployeeByIdGoldenPathTest() {
        try {
            Employee addedEmployeeToCheck = toTest.getEmployeeById(1);

            assertEquals(1, addedEmployeeToCheck.getId());
            assertEquals("Noel", addedEmployeeToCheck.getFirstName());
            assertEquals("Castillo", addedEmployeeToCheck.getLastName());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void updateEmployeeGoldenPathTest() {
        try {

            Employee employeeToUpdate = toTest.getEmployeeById(1);
            employeeToUpdate.setFirstName("Joe");
            employeeToUpdate.setLastName("Schmo");
            toTest.editEmployee(1, employeeToUpdate);

            Employee updatedEmployee = toTest.getEmployeeById(1);

            assertEquals(1, updatedEmployee.getId());
            assertEquals("Joe", updatedEmployee.getFirstName());
            assertEquals("Schmo", updatedEmployee.getLastName());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void deleteEmployeeGoldenPathTest() {
        try {

            assertNotNull(toTest.getEmployeeById(1));
            toTest.deleteEmployee(1);
            assertNull(toTest.getEmployeeById(1));

        } catch (Exception e) {
            fail();
        }

    }


}

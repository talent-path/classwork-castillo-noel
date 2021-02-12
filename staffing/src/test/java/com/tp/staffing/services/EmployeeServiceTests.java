package com.tp.staffing.services;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

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
    public void addEmployeeNullFirstNameTest() {
        try {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setFirstName(null);
            employeeToAdd.setLastName("Schmo");
            toTest.addEmployee(employeeToAdd);

        } catch(NullEmployeeFirstNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void addEmployeeNullLastNameTest() {
        try {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setFirstName("Joe");
            employeeToAdd.setLastName(null);
            toTest.addEmployee(employeeToAdd);

        } catch(NullEmployeeLastNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void addEmployeeEmptyFirstNameTest() {
        try {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setFirstName("");
            employeeToAdd.setLastName("Schmo");
            toTest.addEmployee(employeeToAdd);

        } catch(InvalidEmployeeFirstNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void addEmployeeEmptyLastNameTest() {
        try {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setFirstName("Joe");
            employeeToAdd.setLastName("");
            toTest.addEmployee(employeeToAdd);

        } catch(InvalidEmployeeLastNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getEmployeeByIdNullIdTest() {
        try {
            toTest.getEmployeeById(null);

        } catch(NullEmployeeIdException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getEmployeeByIdInvalidUpperBoundIdTest() {
        try {
            toTest.getEmployeeById(Integer.MAX_VALUE);

        } catch(InvalidEmployeeIdException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getEmployeeByIdInvalidLowerBoundIdTest() {
        try {
            toTest.getEmployeeById(Integer.MIN_VALUE);

        } catch(InvalidEmployeeIdException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void editEmployeeNullFirstNameTest() {
        try {
            Employee editedEmployee = new Employee();
            editedEmployee.setFirstName(null);
            editedEmployee.setLastName("Schmo");
            toTest.editEmployee(1, editedEmployee);

        } catch(NullEmployeeFirstNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void editEmployeeNullLastNameTest() {
        try {
            Employee editedEmployee = new Employee();
            editedEmployee.setFirstName("Joe");
            editedEmployee.setLastName(null);
            toTest.editEmployee(1, editedEmployee);

        } catch(NullEmployeeLastNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void editEmployeeEmptyFirstNameTest() {
        try {
            Employee editedEmployee = new Employee();
            editedEmployee.setFirstName("");
            editedEmployee.setLastName("Schmo");
            toTest.editEmployee(1, editedEmployee);

        } catch(InvalidEmployeeFirstNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void editEmployeeEmptyLastNameTest() {
        try {
            Employee editedEmployee = new Employee();
            editedEmployee.setFirstName("Joe");
            editedEmployee.setLastName("");
            toTest.editEmployee(1, editedEmployee);

        } catch(InvalidEmployeeLastNameException e){
            //Nothing done since we want this.
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }



}

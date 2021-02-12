package com.tp.staffing.service;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.persistence.EmployeePostgresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeePostgresDao dao;

    public Integer addEmployee(Employee employee) throws NullEmployeeFirstNameException, NullEmployeeLastNameException, InvalidEmployeeFirstNameException, InvalidEmployeeLastNameException {

        if (employee.getFirstName() == null) {
            throw new NullEmployeeFirstNameException("You cannot add a Employee with a null first name.");
        }
        if (employee.getLastName() == null) {
            throw new NullEmployeeLastNameException("You cannot add a Employee with a null last name.");
        }
        if (employee.getFirstName().trim().equals("")) {
            throw new InvalidEmployeeFirstNameException("You cannot add a Employee with a empty first name.");
        }
        if (employee.getLastName().trim().equals("")) {
            throw new InvalidEmployeeLastNameException("You cannot add a Employee with a empty last name.");
        }
        return dao.addEmployee(employee);
    }

    public Employee getEmployeeById(Integer id) throws NullEmployeeIdException, InvalidEmployeeIdException {
        if (id == null) {
            throw new NullEmployeeIdException("You cannot retrieve an Employee with null id.");
        }

        Employee employeeToReturn = dao.getEmployeeById(id);
        if (employeeToReturn == null) {
            throw new InvalidEmployeeIdException("No Employee with that ID exists.");
        } else {
            return employeeToReturn;
        }

    }

    public List<Employee> getEmployeesByLastName(String lastName) throws NullEmployeeLastNameException {
        if (lastName == null) {
            throw new NullEmployeeLastNameException("You cannot retrieve an Employee with null last name.");
        }
        return dao.getEmployeesByLastName(lastName);
    }

    public List<Employee> getEmployees() {
        return dao.getEmployees();
    }

    public boolean editEmployee(Integer id, Employee employee) throws NullEmployeeFirstNameException, NullEmployeeLastNameException, InvalidEmployeeFirstNameException, InvalidEmployeeLastNameException {
        if (employee.getFirstName() == null) {
            throw new NullEmployeeFirstNameException("You cannot edit a Employee to have a null first name.");
        }
        if (employee.getLastName() == null) {
            throw new NullEmployeeLastNameException("You cannot edit a Employee to have a null last name.");
        }
        if (employee.getFirstName().trim().equals("")) {
            throw new InvalidEmployeeFirstNameException("You cannot edit a Employee to have a empty first name.");
        }
        if (employee.getLastName().trim().equals("")) {
            throw new InvalidEmployeeLastNameException("You cannot edit a Employee to have a empty last name.");
        }
        return dao.editEmployee(id, employee);
    }

    public boolean deleteEmployee(Integer id) throws NullEmployeeIdException {
        if (id == null) {
            throw new NullEmployeeIdException("You cannot delete a Employee with null id.");
        }
        return dao.deleteEmployee(id);
    }


}

package com.tp.staffer.persistence;

import com.tp.staffer.exceptions.InvalidEmployeeIdException;
import com.tp.staffer.model.Employee;
import com.tp.staffer.model.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class EmployeeInMemDAO implements EmployeeDAO {
    List<Employee> allEmployees = new ArrayList<>();

    @Override
    public Employee getEmployeeById(Integer id) throws InvalidEmployeeIdException {
        for (Employee employee : allEmployees) {
            if (employee.getId().equals(id)) {
                return new Employee(employee);
            }
        }
        throw new InvalidEmployeeIdException("No Employee with " + id);
    }



    @Override
    public Employee newEmployee(Employee employee) {
//        Lines 86 & 87 need to be commented for testing. Uncommented for production.
//        book.setId(id);
//        id++;

        allEmployees.add(employee);
        return employee;
    }

}




package com.tp.staffing.persistence;

import com.tp.staffing.exceptions.InvalidEmployeeIdException;
import com.tp.staffing.model.Employee;

import java.awt.print.Book;
import java.util.List;

public interface EmployeeDAO {

    Employee getEmployeeById(Integer id) throws InvalidEmployeeIdException;

    List<Employee> getEmployeesByLastName(String lastName);

    List<Employee> getEmployees();

    Integer newEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee editEmployee(Integer id, Employee updatedEmployee);


}

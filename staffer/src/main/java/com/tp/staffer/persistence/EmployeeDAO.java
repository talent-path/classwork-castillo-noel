package com.tp.staffer.persistence;

import com.tp.staffer.exceptions.InvalidEmployeeIdException;
import com.tp.staffer.model.Employee;
import com.tp.staffer.model.Position;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployeeById(Integer id) throws InvalidEmployeeIdException;

    Employee newEmployee(Employee employee);


}

package com.tp.staffing.persistence;

import com.tp.staffing.exceptions.InvalidEmployeeIdException;
import com.tp.staffing.model.Employee;

public interface EmployeeDAO {

    Employee getEmployeeById(Integer id) throws InvalidEmployeeIdException;

    Employee newEmployee(Employee employee);


}

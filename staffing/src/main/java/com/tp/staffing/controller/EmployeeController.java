package com.tp.staffing.controller;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) throws NullEmployeeIdException, InvalidEmployeeIdException {
        return service.getEmployeeById(id);
    }

    @GetMapping("/employees/{lastName}")
    public List<Employee> getEmployeesByLastName(@PathVariable String lastName) throws NullEmployeeLastNameException {
        return service.getEmployeesByLastName(lastName);
    }

    @GetMapping("/employees/")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PostMapping("/employees/new-employee")
    public Employee newEmployee(@RequestBody Employee employee) throws InvalidEmployeeFirstNameException, NullEmployeeLastNameException, NullEmployeeFirstNameException, InvalidEmployeeLastNameException {
        return service.newEmployee(employee);
    }

}

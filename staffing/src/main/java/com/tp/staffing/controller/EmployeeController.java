package com.tp.staffing.controller;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) throws NullEmployeeIdException, InvalidEmployeeIdException {
        return service.getEmployeeById(id);
    }

    @PostMapping("/employees/new-employee")
    public Employee newEmployee(@RequestBody Employee employee) throws InvalidEmployeeFirstNameException, NullEmployeeLastNameException, NullEmployeeFirstNameException, InvalidEmployeeLastNameException {
        return service.newEmployee(employee);
    }


}

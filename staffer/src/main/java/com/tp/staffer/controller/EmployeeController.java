package com.tp.staffer.controller;


import com.tp.staffer.exceptions.*;
import com.tp.staffer.model.Employee;
import com.tp.staffer.model.Position;
import com.tp.staffer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees/{id}")
    public Position getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/employees/new-employee")
    public Employee newEmployee(@RequestBody Employee employee) {
        return service.newPosition(position);
    }


}

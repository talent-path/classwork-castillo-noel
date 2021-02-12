package com.tp.staffing.controller;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import com.tp.staffing.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    PositionService service;

    @PostMapping("/positions/add-position")
    public Integer addPosition(@RequestBody Position position) throws NullPositionTitleException, InvalidPositionTitleException {
        return service.addPosition(position);
    }

    @GetMapping("/position/{id}")
    public Position getPositionById(@PathVariable Integer id) throws NullPositionIdException, InvalidPositionIdException {
        return service.getPositionById(id);
    }


    @GetMapping("/positions/{title}")
    public List<Position> getPositionsByTitle(@PathVariable String title) throws NullPositionTitleException, InvalidPositionTitleException {
        return service.getPositionsByTitle(title);
    }

    @GetMapping("/positions")
    public List<Position> getPositions() {
        return service.getPositions();
    }

    @DeleteMapping("/positions/delete/{id}")
    public String deletePosition(@PathVariable Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (service.deletePosition(id)) {
            return "Position " + id + " deleted";
        } else {
            return "Position " + id + " not found";
        }
    }

    @PutMapping("/positions/{id}")
    public String editPosition(@PathVariable Integer id, @RequestBody Position position) throws InvalidPositionTitleException, NullPositionTitleException, InvalidPositionIdException {
        if (service.editPosition(id, position)) {
            return "Position " + id + " updated";
        } else {
            return "Position " + id + " not found";
        }

    }

    @PutMapping("/employee/{employeeId}/position/{positionId}")
    public String addEmployeeToPosition(@PathVariable Integer employeeId, @PathVariable Integer positionId) throws NullEmployeeIdException, NullPositionIdException, InvalidPositionIdException {
        if (service.addEmployeeToPosition(employeeId, positionId)) {
            return "Employee " + employeeId + " has taken Position " + positionId;
        } else {
            return "Unable to locate associated Employee " + employeeId + " or Position " + positionId;
        }
    }

    @PutMapping("/position/{id}/clear")
    public String removeEmployeeFromPosition(@PathVariable Integer id) throws InvalidPositionIdException, NullPositionIdException {
        if (service.removeEmployeeFromPosition(id)) {
            return "Position " + id + " is now vacant.";
        } else {
            return "Unable to locate associated Position " + id + ".";
        }
    }

}

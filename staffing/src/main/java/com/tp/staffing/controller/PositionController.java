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

    @GetMapping("/position/{id}")
    public Position getPositionById(@PathVariable Integer id) throws NullPositionIdException {
        return service.getPositionById(id);
    }


    @GetMapping("/positions/{title}")
    public List<Position> getPositionsByTitle(@PathVariable String title) throws NullPositionTitleException {
        return service.getPositionsByTitle(title);
    }

    @GetMapping("/positions")
    public List<Position> getPositions()  {
        return service.getPositions();
    }

    @PostMapping("/positions/new-position")
    public Position newPosition(@RequestBody Position position) throws NullPositionTitleException, InvalidPositionTitleException {
        return service.newPosition(position);
    }

}

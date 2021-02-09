package com.tp.staffing.controller;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Position;
import com.tp.staffing.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PositionController {
    @Autowired
    PositionService service;

    @GetMapping("/positions/{id}")
    public Position getPositionById(@PathVariable Integer id) throws NullPositionIdException {
        return service.getPositionById(id);
    }

    @PostMapping("/positions/new-position")
    public Position newPosition(@RequestBody Position position) throws NullPositionTitleException, InvalidPositionTitleException {
        return service.newPosition(position);
    }

}

package com.tp.staffing.service;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import com.tp.staffing.persistence.PositionPostgresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionPostgresDao dao;

    public Integer addPosition(Position position) throws NullPositionTitleException, InvalidPositionTitleException {
        if (position.getTitle() == null) {
            throw new NullPositionTitleException("You cannot add a Position with a null title.");
        }

        if (position.getTitle().trim().equals("")) {
            throw new InvalidPositionTitleException("You cannot add a Position with a empty title.");
        }
        return dao.addPosition(position);
    }

    public Position getPositionById(Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (id == null) {
            throw new NullPositionIdException("You cannot retrieve a Position with null id.");
        }

        Position positionToReturn = dao.getPositionById(id);
        if(positionToReturn == null){
            throw new InvalidPositionIdException("No Position with that ID exists.");
        } else{
            return positionToReturn;
        }

    }

    public List<Position> getPositionsByTitle(String title) throws NullPositionTitleException, InvalidPositionTitleException {
        if (title == null) {
            throw new NullPositionTitleException("You cannot retrieve Positions with a null title.");
        }

        if (title.trim().equals("")) {
            throw new InvalidPositionTitleException("You cannot retrieve Positions with a empty title.");
        }
        return dao.getPositionsByTitle(title);
    }

    public List<Position> getPositions() {
        return dao.getPositions();
    }

    public boolean editPosition(Integer id, Position position) throws InvalidPositionTitleException, NullPositionTitleException, InvalidPositionIdException {
        if (position.getTitle() == null) {
            throw new NullPositionTitleException("You cannot edit a Position to have a null title.");
        }

        if (position.getTitle().trim().equals("")) {
            throw new InvalidPositionTitleException("You cannot edit a Position with a empty title.");
        }
        return dao.editPosition(id, position);
    }

    public boolean deletePosition(Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (id == null) {
            throw new NullPositionIdException("You cannot delete a Position with null id.");
        }
        return dao.deletePosition(id);
    }

    public boolean addEmployeeToPosition(Integer employeeId, Integer positionId) throws NullEmployeeIdException, NullPositionIdException, InvalidPositionIdException {
        if (employeeId == null) {
            throw new NullEmployeeIdException("You cannot retrieve an Employee with null id.");
        }

        if (positionId == null) {
            throw new NullPositionIdException("You cannot retrieve a Position with null id.");
        }
        return dao.addEmployeeToPosition(employeeId, positionId);
    }


    public boolean removeEmployeeFromPosition(Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (id == null) {
            throw new NullPositionIdException("Cannot locate a Position with null id.");
        }
        return dao.removeEmployeeFromPosition(id);
    }
}

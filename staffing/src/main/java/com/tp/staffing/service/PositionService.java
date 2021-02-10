package com.tp.staffing.service;


import com.tp.staffing.exceptions.*;
import com.tp.staffing.model.Position;
import com.tp.staffing.persistence.PositionPostgresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionPostgresDao dao;

    public Position getPositionById(Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (id == null) {
            throw new NullPositionIdException("You cannot retrieve a Position with null id.");
        }
        return dao.getPositionById(id);
    }

    public List<Position> getPositionsByTitle(String title) throws NullPositionTitleException {
        if (title == null) {
            throw new NullPositionTitleException("You cannot retrieve Positions with a null title.");
        }
        return dao.getPositionsByTitle(title);
    }

    public List<Position> getPositions() {
        return dao.getPositions();
    }

    public Integer newPosition(Position position) throws NullPositionTitleException, InvalidPositionTitleException {
        if (position.getTitle() == null) {
            throw new NullPositionTitleException("You cannot add a Position with a null title.");
        }

        if (position.getTitle().trim().equals("")) {
            throw new InvalidPositionTitleException("You cannot add a Position with a empty title.");
        }
        return dao.newPosition(position);
    }

    public boolean deletePosition(Integer id) throws NullPositionIdException, InvalidPositionIdException {
        if (id == null) {
            throw new NullPositionIdException("You cannot delete a Position with null id.");
        }
        return dao.deletePosition(id);
    }



}

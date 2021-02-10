package com.tp.staffing.persistence;


import com.tp.staffing.exceptions.InvalidPositionIdException;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;

import java.util.List;

public interface PositionDAO {

    Position getPositionById(Integer id) throws InvalidPositionIdException;

    List<Position> getPositionsByTitle(String title);

    List<Position> getPositions();

    Integer newPosition(Position position);

    boolean deletePosition(Integer id) throws InvalidPositionIdException;

}

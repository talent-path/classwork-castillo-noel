package com.tp.staffing.persistence;


import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;

import java.util.List;

public interface PositionDAO {

    Position getPositionById(Integer id);

    List<Position> getPositionsByTitle(String title);

    List<Position> getPositions();

    Position newPosition(Position position);

}

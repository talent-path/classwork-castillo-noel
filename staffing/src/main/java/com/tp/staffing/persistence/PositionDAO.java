package com.tp.staffing.persistence;


import com.tp.staffing.model.Position;

public interface PositionDAO {

    Position getPositionById(Integer id);

    Position newPosition(Position position);

}

package com.tp.staffing.persistence.mappers;

import com.tp.staffing.model.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {

    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position mappedPosition = new Position();
        mappedPosition.setId(resultSet.getInt("id"));
        mappedPosition.setTitle(resultSet.getString("title"));
        mappedPosition.setEmployeeId(resultSet.getInt("employeeId"));

        return mappedPosition;
    }
}

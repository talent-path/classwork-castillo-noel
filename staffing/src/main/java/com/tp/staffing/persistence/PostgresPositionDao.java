package com.tp.staffing.persistence;

import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PostgresPositionDao implements PositionDAO {


    @Autowired
    JdbcTemplate template;

    @Override
    public Position getPositionById(Integer id) {
        List<Position> positions = template.query("SELECT id, \"title\"\n" +
                "\tFROM public.\"Position\"\n" +
                "\t\tWHERE \"id\" = '" + id + "';", new PositionMapper());

        if (positions.isEmpty()) {
            return null;
        }

        return positions.get(0);
    }

    @Override
    public List<Position> getPositions() {
        List<Position> positions = template.query("SELECT id, \"title\"\n" +
                "\tFROM public.\"Position\"\n;", new PostgresPositionDao.PositionMapper());

        if (positions.isEmpty()) {
            return null;
        }

        return positions;
    }

    @Override
    public List<Position> getPositionsByTitle(String title) {
        List<Position> positions = template.query("SELECT id, \"title\"\n" +
                "\tFROM public.\"Position\"\n" +
                "\t\tWHERE \"title\" = '" + title + "';", new PostgresPositionDao.PositionMapper());

        if (positions.isEmpty()) {
            return null;
        }

        return positions;
    }

    @Override
    public Position newPosition(Position position) {

        return null;
    }

    private class PositionMapper implements RowMapper<Position> {

        @Override
        public Position mapRow(ResultSet resultSet, int i) throws SQLException {
            Position mappedPosition = new Position();
            mappedPosition.setId(resultSet.getInt("id"));
            mappedPosition.setTitle(resultSet.getString("title"));

            return mappedPosition;
        }
    }
}

package com.tp.staffing.persistence;

import com.tp.staffing.exceptions.InvalidPositionIdException;
import com.tp.staffing.model.Employee;
import com.tp.staffing.model.Position;
import com.tp.staffing.persistence.mappers.EmployeeMapper;
import com.tp.staffing.persistence.mappers.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PositionPostgresDao implements PositionDAO {


    @Autowired
    private JdbcTemplate template;

    @Override
    public Integer newPosition(Position position) {

        return template.query("INSERT INTO public.\"Position\"(\"title\")" +
                "VALUES ( '"+ position.getTitle() + "') " +
                "RETURNING \"id\";", new PositionPostgresDao.IdMapper()).get(0);
    }

    @Override
    public Position getPositionById(Integer id) throws InvalidPositionIdException {
        List<Position> positions = template.query("SELECT id, \"title\", \"employeeId\"\n" +
                "\tFROM public.\"Position\"\n" +
                "\t\tWHERE \"id\" = '" + id + "';", new PositionMapper());

        if (positions.isEmpty()) {
            throw new InvalidPositionIdException("No Position with that ID exists.");
        }

        return positions.get(0);
    }

    @Override
    public List<Position> getPositions() {
        List<Position> positions = template.query("SELECT id, \"title\", \"employeeId\"\n" +
                "\tFROM public.\"Position\"\n;", new PositionPostgresDao.PositionMapper());

        if (positions.isEmpty()) {
            return null;
        }

        return positions;
    }

    @Override
    public List<Position> getPositionsByTitle(String title) {
        List<Position> positions = template.query("SELECT id, \"title\", \"employeeId\"\n" +
                "\tFROM public.\"Position\"\n" +
                "\t\tWHERE \"title\" = '" + title + "';", new PositionPostgresDao.PositionMapper());

        if (positions.isEmpty()) {
            return null;
        }

        return positions;
    }

    @Override
    public boolean editPosition(Integer id, Position updatedPosition) throws InvalidPositionIdException {
       if (getPositionById(id) == null) {
            return false;
        } else {
            template.execute("UPDATE public.\"Position\"\n" +
                    "SET \"title\"='" + updatedPosition.getTitle() + "'\n" +
                    "WHERE \"id\" = " + id + ";");
            return true;
        }
    }

    @Override
    public boolean deletePosition(Integer id) throws InvalidPositionIdException {

        if (getPositionById(id) == null) {
            return false;
        } else {
            template.execute("DELETE FROM public.\"Position\" " +
                    "WHERE \"id\" = " + id + ";");
            return true;
        }
    }

    @Override
    public boolean addEmployeeToPosition(Integer employeeId, Integer positionId) throws InvalidPositionIdException {

        List<Employee> employees = template.query("SELECT id, \"firstName\", \"lastName\"\n" +
                "\tFROM public.\"Employee\"\n" +
                "\t\tWHERE \"id\" = '" + employeeId + "';", new EmployeeMapper());
        if (employees.isEmpty()) {
            return false;
        }

        if (getPositionById(positionId) == null) {
            return false;
        } else {
            template.execute("UPDATE public.\"Position\"\n" +
                    "SET \"employeeId\"='" + employeeId + "'\n" +
                    "WHERE \"id\" = " + positionId + ";");
            return true;
        }

    }

    @Override
    public boolean removeEmployeeFromPosition(Integer positionId) throws InvalidPositionIdException {

        if (getPositionById(positionId) == null) {
            return false;
        } else {
            template.execute("UPDATE public.\"Position\"\n" +
                    "SET \"employeeId\"=null\n" +
                    "WHERE \"id\" = " + positionId + ";");
            return true;
        }

    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("id");
        }
    }

    private class PositionMapper implements RowMapper<Position> {

        @Override
        public Position mapRow(ResultSet resultSet, int i) throws SQLException {
            Position mappedPosition = new Position();
            mappedPosition.setId(resultSet.getInt("id"));
            mappedPosition.setTitle(resultSet.getString("title"));
            mappedPosition.setEmployeeId(resultSet.getInt("employeeId"));

            return mappedPosition;
        }
    }
}

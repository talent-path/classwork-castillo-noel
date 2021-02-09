package com.tp.staffer.persistence;

import com.tp.staffer.model.Employee;
import com.tp.staffer.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresEmployeeDao implements EmployeeDAO {


    @Autowired
    JdbcTemplate template;

    @Override
    public Employee getEmployeeById(Integer id)  {
        List<Integer> employees = template.query("SELECT id, name\n" +
                "\tFROM public.\"Employee\"\n" +
                "\t\tWHERE \"id\" = '" + id + "';", new IdMapper());

        if(employees.isEmpty()){
            return null;
        }

        return null;
    }


    @Override
    public Employee newEmployee(Employee employee) {

//        List<Integer> employeeList = new ArrayList<>();
//
//        for (String author : book.getAuthors()) {
//            Integer authorId = addOrRetrieve(author);
//            authorList.add(authorId);
//        }
        return null;
    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("id");
        }
    }
}

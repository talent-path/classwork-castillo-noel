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

//    private Integer addOrRetrieve(String author) {
//
//        Integer authorId = getAuthorId(author);
//
//        if (authorId == null) {
//            authorId = addAuthor(author);
//        }
//
//        return authorId;
//    }
//
//    private Integer getAuthorId(String author) {
//
//        List<Integer> id = template.query("SELECT id, name\n" +
//                "\tFROM public.\"Author\"\n" +
//                "\t\tWHERE \"name\" = '" + author + "';", new IdMapper());
//
//        if(id.isEmpty()){
//            return null;
//        }
//
//        return id.get(0);
//    }
//
//
//
//    private Integer addAuthor(String author) {
//
//        return template.query("INSERT INTO public.\"Author\"(name)\n" +
//                        "\tVALUES ('" + author + "')\n" +
//                        "\t\tRETURNING \"id\";",
//                new IdMapper()).get(0);
//    }
//
//    private class IdMapper implements RowMapper<Integer> {
//
//        @Override
//        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
//            return resultSet.getInt("id");
//        }
//    }
}

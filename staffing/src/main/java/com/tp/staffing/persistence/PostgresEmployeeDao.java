package com.tp.staffing.persistence;

import com.tp.staffing.model.Employee;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PostgresEmployeeDao implements EmployeeDAO {


    @Autowired
    JdbcTemplate template;

    @Override
    public Employee getEmployeeById(Integer id) {
        List<Employee> employees = template.query("SELECT id, \"firstName\", \"lastName\"\n" +
                "\tFROM public.\"Employee\"\n" +
                "\t\tWHERE \"id\" = '" + id + "';", new EmployeeMapper());

        if (employees.isEmpty()) {
            return null;
        }

        return employees.get(0);
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        List<Employee> employees = template.query("SELECT id, \"firstName\", \"lastName\"\n" +
                "\tFROM public.\"Employee\"\n" +
                "\t\tWHERE \"lastName\" = '" + lastName + "';", new EmployeeMapper());

        if (employees.isEmpty()) {
            return null;
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = template.query("SELECT id, \"firstName\", \"lastName\"\n" +
                "\tFROM public.\"Employee\"\n;", new EmployeeMapper());

        if (employees.isEmpty()) {
            return null;
        }

        return employees;
    }




    @Override
    public Employee newEmployee(Employee employee) {

//        INSERT INTO public."Employee"(
//                id, "firstName", "lastName")
//        VALUES (?, ?, ?);
//
//        List<Employee> employees = template.query("INSERT INTO public.\"Employee\"(\"firstName\", \"lastName\")" +
//                "VALUES ( id, name\n" +
//                "\tFROM public.\"Employee\"\n" +
//                "\t\tWHERE \"id\" = '" + id + "';", new EmployeeMapper());
//
//        if (employees.isEmpty()) {
//            return null;
//        }
//
//        return employees.get(0);

//        List<Integer> employeeList = new ArrayList<>();
//
//        for (String author : book.getAuthors()) {
//            Integer authorId = addOrRetrieve(author);
//            authorList.add(authorId);
//        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {
        
    }

    @Override
    public Employee editEmployee(Integer id, Employee updatedEmployee) {
        return null;
    }

    private class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee mappedEmployee = new Employee();
            mappedEmployee.setId(resultSet.getInt("id"));
            mappedEmployee.setFirstName(resultSet.getString("firstName"));
            mappedEmployee.setLastName(resultSet.getString("lastName"));
            return mappedEmployee;
        }
    }
}

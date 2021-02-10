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
public class EmployeePostgresDao implements EmployeeDAO {


    @Autowired
    private JdbcTemplate template;

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
    public Integer newEmployee(Employee employee) {

        return template.query("INSERT INTO public.\"Employee\"(\"firstName\", \"lastName\")" +
                "VALUES ( '" + employee.getFirstName() + "', '" + employee.getLastName() + "') " +
                "RETURNING \"id\";", new IdMapper()).get(0);

    }

    @Override
    public boolean deleteEmployee(Integer id) {

        if (getEmployeeById(id) == null) {
            return false;
        } else {
            template.execute("DELETE FROM public.\"Employee\" " +
                    "WHERE \"id\" = " + id + ";");
            return true;
        }
    }

    @Override
    public Employee editEmployee(Integer id, Employee updatedEmployee) {
        return null;
    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("id");
        }
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

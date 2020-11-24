package com.xu.jdbc.dao;

import com.xu.jdbc.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
        jdbcTemplate.update(sql, employee.getEmpName(), employee.getSalary());
    }


    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");
    }

}

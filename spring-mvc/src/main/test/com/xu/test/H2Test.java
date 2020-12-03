package com.xu.test;

import com.xu.pojo.Teacher;
import org.h2.engine.ConnectionInfo;
import org.h2.engine.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xuhongda on 2020/12/3
 * com.xu.test
 * spring-practice
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml", "classpath:spring-config.xml"})
public class H2Test {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {

        String selectSql = "select * from teacher";

        List<Teacher> query = jdbcTemplate.query(selectSql, (resultSet, i) -> {
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt(1));
            teacher.setName(resultSet.getString(2));
            teacher.setAge(resultSet.getInt(3));
            return teacher;
        });

        query.forEach(System.out::println);
    }


}

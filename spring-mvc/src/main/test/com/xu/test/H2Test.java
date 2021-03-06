package com.xu.test;

import com.xu.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
            teacher.setId(resultSet.getInt("id")); //对应表字段名
            teacher.setName(resultSet.getString("name"));
            teacher.setAge(resultSet.getInt("age"));
            return teacher;
        });

        query.forEach(System.out::println);
    }


    @Test
    public void test2() {

        String selectSql = "select * from teacher";

        List<Teacher> teachers = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(Teacher.class));

        teachers.forEach(System.out::println);


    }


}

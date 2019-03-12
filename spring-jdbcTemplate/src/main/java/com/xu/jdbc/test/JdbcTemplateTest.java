package com.atguigu.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.xu.jdbc.bean.Employee;
import com.xu.jdbc.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class JdbcTemplateTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcConfig.xml");
    /**
     * 不支持具名参数的功能
     */
    private JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    /**
     * 支持具名参数功能的jdbcTemplate
     */
    private NamedParameterJdbcTemplate njp = ioc.getBean(NamedParameterJdbcTemplate.class);


    @Test
    public void test09() {
        EmployeeDao employeeDao = ioc.getBean(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setEmpName("dshkjahdajk");
        employee.setSalary(9998.98);
        employeeDao.saveEmployee(employee);
    }

    /**
     * BookService.saveBook(book)
     * 实验8：重复实验7，以SqlParameterSource形式传入参数值
     * BookDao.saveBook(sql,book.getId,book.getName)
     */
    @Test
    public void jdbcTemplate08() {
        Employee employee = new Employee();
        employee.setEmpName("张三1234");
        employee.setSalary(9989.98);

        String sql = "INSERT INTO employee(emp_name,salary) VALUES(:empName,:salary)";
        int update = njp.update(sql, new BeanPropertySqlParameterSource(employee));
        System.out.println(update);

    }

    /**
     * 实验7：使用带有[具名参数]的SQL语句插入一条员工记录，并以Map形式传入参数值
     * <p>
     * [具名参数]：具有名字的参数
     * 以前都是?占位符的形式；不太人性化
     * <p>
     * 为参数的位置起名；   [:自定义名]
     * "INSERT INTO employee(emp_name,salary) VALUES(:empname,:salary)";
     */
    @Test
    public void jdbcTemplate07() {
        String sql = "INSERT INTO employee(emp_name,salary) VALUES(:empName,:salary)";
        Map<String, Object> maps = new HashMap<>(2);
        maps.put("empName", "哈哈哈");
        maps.put("salary", 998);

        int update = njp.update(sql, maps);
        System.out.println(update);

    }

    /**
     * 实验6：查询最大salary
     */
    @Test
    public void jdbcTemplate06() {
        String sql = "SELECT MAX(salary) FROM employee";
        Double max = jdbcTemplate.queryForObject(sql, Double.class);
        System.out.println(max);
    }

    /**
     * 实验5：查询salary>4000的数据库记录，封装为List集合返回
     * <p>
     * 查集合：query方法传入BeanPropertyRowMapper表示集合里面元素的类型
     */
    @Test
    public void jdbcTemplate05() {
        String sql = "SELECT emp_id id,emp_name empName,salary FROM employee WHERE salary>?";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), 4000);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
     * <p>
     * 查单个对象：queryForObject传入一个BeanPropertyRowMapper
     */
    @Test
    public void jdbcTemplate04() {
        String sql = "SELECT emp_id id,emp_name empName,salary FROM employee WHERE emp_id=?";
        //BeanHandler
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 5);
        System.out.println(employee);
    }


    /**
     * 实验3：批量插入
     * Object[][]:
     * 第一维的长度代表sql执行的此时
     * 第二维是保存当次执行使用的参数
     */
    @Test
    public void jdbcTemplate03() {
        String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"张三", 1234});
        batchArgs.add(new Object[]{"张三2", 12345});
        batchArgs.add(new Object[]{"张三3", 12346});
        int[] is = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("完成...");
    }

    /**
     * 实验2：将emp_id=5的记录的salary字段更新为1300.00
     */
    @Test
    public void jdbcTemplate02() {
        String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
        int i = jdbcTemplate.update(sql, 1300.12, 5);
        System.out.println(i);

    }

    @Test
    public void test02() {
        System.out.println(jdbcTemplate);
    }

    @Test
    public void test01() {
		/*DataSource dataSource = ioc.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);*/
    }

    @Test
    public void test() throws SQLException {
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}

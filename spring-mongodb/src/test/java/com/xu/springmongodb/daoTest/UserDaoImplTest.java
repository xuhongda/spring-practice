package com.xu.springmongodb.daoTest;

import com.xu.pojo.Car;
import com.xu.pojo.Girl;
import com.xu.springmongodb.dao.impl.GirlDaoImpl;
import com.xu.springmongodb.dao.impl.UserDaoImpl;
import com.xu.springmongodb.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2018/8/22
 * com.xu.springmongodb.dao.impl
 * spring-practice
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserDaoImplTest {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private GirlDaoImpl girlDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void saveCar() throws ParseException {
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String d1= "2021-12-11";
        Date parse = format.parse(d1);

        String d2= "2021-10-11";
        Date parse1 = format.parse(d2);

        String d3= "2021-11-11";
        Date parse2 = format.parse(d3);


        Car car = new Car("1","1","11", parse);
        Car car2 = new Car("2","2","11", parse1);
        Car car3 = new Car("1","1","11", parse2);
        mongoTemplate.save(car);
        mongoTemplate.save(car2);
        mongoTemplate.save(car3);
    }

    @Test
    public void findCar() {
        Query query = new Query(Criteria.where("brand").is("2").and("date").lte(new Date()));
        List<Car> cars = mongoTemplate.find(query, Car.class);
        log.warn("cars = {}",cars);
    }

    @Test
    public void saveUser() {

        userDao.saveUser(new User(22222L,"xu","1234"));
    }

    @Test
    public void saveGirl() {
        girlDao.saveGirl(new Girl("漂亮","liu","18"));
    }

    @Test
    public void deleteGirl() {
        Query query = new Query(Criteria.where("lookLike").is("漂亮"));
        girlDao.deleteGirl(query);
    }

    @Test
    public void findByName() {
        User xu = userDao.findByName("xu");
        System.out.println(xu);
    }

    @Test
    public void updateUser() {
        boolean b = userDao.updateUser(new User(22222L, "yan", "ai"));
        System.out.println(b);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1L);
    }
}
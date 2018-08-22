package com.xu.springmongodb.daoTest;

import com.xu.springmongodb.dao.impl.UserDaoImpl;
import com.xu.springmongodb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuhongda on 2018/8/22
 * com.xu.springmongodb.dao.impl
 * spring-practice
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoImplTest {

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void savaUser() {

        userDao.savaUser(new User(22222L,"xu","1234"));
    }

    @Test
    public void findByName() {
    }

    @Test
    public void updataUser() {
    }

    @Test
    public void deleteUserById() {
    }
}
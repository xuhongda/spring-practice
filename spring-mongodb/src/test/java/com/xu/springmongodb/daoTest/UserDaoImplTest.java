package com.xu.springmongodb.daoTest;

import com.xu.pojo.Girl;
import com.xu.springmongodb.dao.impl.GirlDaoImpl;
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

    @Autowired
    private GirlDaoImpl girlDao;

    @Test
    public void saveUser() {

        userDao.saveUser(new User(22222L,"xu","1234"));
    }

    @Test
    public void saveGirl() {
        girlDao.saveGirl(new Girl("漂亮","liu","18"));
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
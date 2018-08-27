package com.xu.springmongodb.dao.impl;

import com.mongodb.WriteResult;
import com.xu.springmongodb.dao.UserDao;
import com.xu.springmongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/22
 * com.xu.springmongodb.dao.impl
 * spring-practice
 */
@Component
public class UserDaoImpl implements UserDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void savaUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findByName(String name) {
        Query query = new Query(Criteria.where("userName").is(name));
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public int updataUser(User user) {
        //1.查出对象
        Query query = new Query(Criteria.where("id").is(user.getId()));
        //2.update
        Update update = new Update().set("userName",user.getUserName()).set("passWord",user.getPassWord());

        WriteResult writeResult = mongoTemplate.updateFirst(query, update, User.class);
        return writeResult.getN();
    }

    @Override
    public void deleteUserById(Long id) {

        Query query = new Query(Criteria.where("id").is(id));

        mongoTemplate.remove(query,User.class);
    }
}

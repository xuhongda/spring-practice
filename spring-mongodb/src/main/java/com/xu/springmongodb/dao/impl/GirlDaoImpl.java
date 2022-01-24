package com.xu.springmongodb.dao.impl;

import com.xu.pojo.Girl;
import com.xu.springmongodb.dao.GirlDao;
import com.xu.springmongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2022/1/24
 * com.xu.springmongodb.dao.impl
 * spring-practice
 */
@Service
public class GirlDaoImpl implements GirlDao {

    private final MongoTemplate mongoTemplate;

    public GirlDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveGirl(Girl girl) {
        mongoTemplate.save(girl);
    }

    @Override
    public void deleteGirl(Query query) {
        mongoTemplate.remove(query, Girl.class);
    }
}

package com.xu.springmongodb.dao.impl;

import com.xu.pojo.Girl;
import com.xu.springmongodb.dao.GirlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}

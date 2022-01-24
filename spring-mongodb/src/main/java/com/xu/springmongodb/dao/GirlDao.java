package com.xu.springmongodb.dao;

import com.xu.pojo.Girl;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author xuhongda on 2022/1/24
 * com.xu.springmongodb.dao
 * spring-practice
 */
public interface GirlDao {
    void saveGirl(Girl girl);

    void deleteGirl(Query query);
}

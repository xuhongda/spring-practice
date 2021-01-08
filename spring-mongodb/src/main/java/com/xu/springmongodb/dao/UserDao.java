package com.xu.springmongodb.dao;

import com.xu.springmongodb.entity.User;

/**
 * @author xuhongda on 2018/8/22
 * com.xu.springmongodb.dao
 * spring-practice
 */
public interface UserDao {

    /**
     * 储存
     * @param user
     */
    void saveUser(User user);

    /**
     * 查询
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 更新
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * 删除
     * @param id
     */
    void deleteUserById(Long id);
}

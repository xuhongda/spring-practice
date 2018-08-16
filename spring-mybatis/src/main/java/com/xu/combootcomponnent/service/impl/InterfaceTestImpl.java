package com.xu.combootcomponnent.service.impl;

import com.xu.combootcomponnent.dao.UserDao;
import com.xu.combootcomponnent.entity.UserEntity;
import com.xu.combootcomponnent.mapper.mysql1Mapper.UserMapper;
import com.xu.combootcomponnent.service.InterfaceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.combootcomponnent.service.impl
 * com-boot-ex
 */
@Service
public class InterfaceTestImpl implements InterfaceTest {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserEntity getoneUser(long id) {
        return userMapper.getOne(1L);
    }

    @Override
    @Transactional
    public void modify(long id) {
        UserEntity one = userMapper.getOne(id);
        one.setUserName("vvvvvvvvv");
        userMapper.update(one);
        throw new RuntimeException();
    }


}

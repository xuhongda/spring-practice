package com.xu.springredis.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2018/8/8
 * com.xu.springredis.redis
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisListTest {
    @Autowired
    private RedisTemplate redisTemplate;
    List list;

    {
        list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
    }

    @Test
    public void test1() {
        redisTemplate.opsForList().leftPush("list1", list);
        Object list1 = redisTemplate.opsForList().leftPop("list1");
        System.err.println(list1);
    }

    @Test
    public void test2(){
        ListOperations listOperations =  redisTemplate.opsForList();
        listOperations.rightPush("list2",list);
        System.out.println(listOperations.rightPop("list2"));
    }

    @Test
    public void test3(){
        ListOperations listOperations = redisTemplate.opsForList();
        RedisOperations operations = listOperations.getOperations();
    }
}

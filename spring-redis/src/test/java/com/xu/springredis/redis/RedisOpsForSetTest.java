package com.xu.springredis.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda on 2019/1/23
 * com.xu.springredis.redis
 * spring-practice
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisOpsForSetTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test() {
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<Integer,Integer> map = new LinkedHashMap<>();
            map.put(i, i);
            list.add(map);
        }
        setOperations.add("yy", list);
    }
}

package com.xu.springredis.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuhongda on 2019/1/23
 * com.xu.springredis.redis
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOpsForZSetTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 有序 set 集合
     */
    @Test
    public void test() {
        ZSetOperations<Object, Object> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            ZSetOperations.TypedTuple<Object> objectTypedTuple = new DefaultTypedTuple<>(i + "v", Double.valueOf(i));
            tuples.add(objectTypedTuple);
        }
        zSetOperations.add("xx", tuples);

    }


}

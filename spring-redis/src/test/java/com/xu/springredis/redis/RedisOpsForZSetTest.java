package com.xu.springredis.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisOperations;
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
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOpsForZSetTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 有序 set 集合
     */
    @Test
    public void test() {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            ZSetOperations.TypedTuple<Object> objectTypedTuple = new DefaultTypedTuple<>(i + "v", (double) i);
            tuples.add(objectTypedTuple);
        }
        Long l = zSetOperations.add("hello", tuples);
        log.info("l = {}",l);
    }

    /**
     * 获取值
     */
    @Test
    public void test2(){
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        Set set = zSetOperations.range("hello",1L,3L);
        log.info("set = {}",set);
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        Set rangeByLex1 = zSetOperations.rangeByLex("hello",range);
        log.info("rangeByLex1 = {}",rangeByLex1);
        Set rangeByLex2 = zSetOperations.rangeByLex("hello",range, RedisZSetCommands.Limit.limit().count(3));
        log.info("rangeByLex2 = {}",rangeByLex2);

    }


}

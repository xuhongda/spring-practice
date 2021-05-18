package com.xu.springredis.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @author xuhongda on 2021/5/18
 * com.xu.springredis.redis
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisAtomicLongTest {
    @Autowired
    private RedisTemplate redisTemplate;

   @Test
   public void test001(){
       RedisAtomicLong redisAtomicLong = new RedisAtomicLong("1", Objects.requireNonNull(redisTemplate.getConnectionFactory()));
       long andIncrement = redisAtomicLong.getAndIncrement();
       System.out.println(andIncrement);
   }
}

package com.xu.springredis.pipeline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author xuhongda on 2021/5/18
 * com.xu.springredis.pipeline
 * spring-practice
 * <p>
 *     pipeline 流水线批量操作
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test001(){
        List<Object> list = redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            StringRedisConnection stringRedisConn = (StringRedisConnection) connection;

            for (int i = 0; i < 10; i++) {
               // stringRedisConn.rPop("myqueue");
              stringRedisConn.set(UUID.randomUUID().toString().substring(0,4),"xxx");
            }
            return null;
        });

        list.forEach(System.out::println);
    }
}

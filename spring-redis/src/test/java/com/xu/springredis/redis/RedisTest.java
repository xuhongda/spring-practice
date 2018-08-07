package com.xu.springredis.redis;

import com.xu.pojo.People;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.springredis.redis
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("1", "3");
        Assert.assertEquals("3", stringRedisTemplate.opsForValue().get("1"));

    }

    /**
     * {@link TimeUnit} 设置有效时间单位
     * @throws InterruptedException 异常
     */
    @Test
    public void test2() throws InterruptedException {
        People people = new People(18,"xuhongda");
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("people",people);
        valueOperations.set("p2",people,30L, TimeUnit.MINUTES);
        valueOperations.set("num",100);
    }

    @Test
    public void test3(){
        //判断是否含有 key
        Boolean b = redisTemplate.hasKey("people");
        System.out.println(b);

        //获取value
        Object people = redisTemplate.opsForValue().get("people");

        //获取过期时间,已过期和无过期都会返回0
        Long time = redisTemplate.getExpire("p2", TimeUnit.SECONDS);
        System.err.println(time);
        //删除
        redisTemplate.delete("people");
        //模糊匹配删除
        Set<String> keys = redisTemplate.keys("key" + "*");
    }

    @Test
    public void test4(){
        //value 追加值
        redisTemplate.boundValueOps("people").append("xxx");
        //value 值 +1
        redisTemplate.boundValueOps("num").increment(1L);
        // -1
        redisTemplate.boundValueOps("num").increment(-1L);

    }


    @Test
    public void test5(){

        //模糊匹配删除
        Set<String> keys = redisTemplate.keys("key" + "*");
        redisTemplate.delete(keys);

       /* for (int i = 0; i <99999; i++) {
            String key = "key"+i;
            redisTemplate.opsForValue().set(key,i);
        }*/

    }

}

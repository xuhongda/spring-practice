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

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.springredis.redis
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOpsValueTest {
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
     *
     */
    @Test
    public void test2()  {
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

        //截取key所对应的value字符串
        redisTemplate.opsForValue().get("people",0,2);

        //获取过期时间,已过期和无过期都会返回0
        Long time = redisTemplate.getExpire("p2", TimeUnit.SECONDS);
        System.err.println(time);
        //删除
        redisTemplate.delete("people");
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
        //偏移覆盖
        redisTemplate.opsForValue().set("key","hello world");
        redisTemplate.opsForValue().set("key","redis", 6);
    }

    @Test
    public void test6(){
        //不存在key 就储存 并返回 boolean
        System.out.println(redisTemplate.opsForValue().setIfAbsent("key","multi1"));
        System.out.println(redisTemplate.opsForValue().setIfAbsent("key2","key2"));

    }

    /**
     * 为多个键赋值，
     */
    @Test
    public void test7(){
        Map<String,String> maps = new HashMap<>();
        maps.put("multi1","multi1");
        maps.put("multi2","multi2");
        maps.put("multi3","multi3");
        redisTemplate.opsForValue().multiSet(maps);
        List<String> keys = new ArrayList<>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        System.out.println(redisTemplate.opsForValue().multiGet(keys));

        //也有判断方法
        redisTemplate.opsForValue().multiSetIfAbsent(maps);

    }

}

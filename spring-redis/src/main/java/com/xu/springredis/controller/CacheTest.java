package com.xu.springredis.controller;

import com.xu.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.springredis.controller
 * spring-practice
 */
@RestController
public class CacheTest {

    /**
     * <p>
     *     默认第一次查询 将会 把 ‘com.xu.springredis.controller.CacheTesthello+[参数]’作为key===》》》全类名+方法名+参数===》》》唯一标识。
     *     后续请求将直接取出value.
     * </p>
     * @param i
     * @return People
     */
    @GetMapping("hello")
    @Cacheable(value = "springCache")
    public People hello(int i){
        return CacheTest.people(i);
    }

    /**
     * 使用了 EL 表达式
     * key:自定义key;condition:缓存条件
     * @param i 参数
     * @return People
     */
    @Cacheable(value = "springCache2", key="#i",condition="#i>100")
    @GetMapping("hello2")
    public People hello2(int i){
        return CacheTest.people(i);
    }
    private static People people(int i){
        People p = new People();
        if (i<5){
            p.setAge(18);
            p.setName("yan");
            return p;
        }else {
            p.setAge(18);
            p.setName("liu");
            return p;
        }
    }
}

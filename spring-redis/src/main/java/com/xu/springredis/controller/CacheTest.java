package com.xu.springredis.controller;

import com.xu.pojo.People;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
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
     * 只有public 方法会被缓存
     * 无参数
     *
     * @return String
     */
    @Cacheable(value = "none")
    @GetMapping("none")
    public String noParam() {
        return "cache no param😂";
    }

    /**
     * spring 4.0 以后有了cacheNames 比value更能表达意思
     */
    @Cacheable(value = "twoArgs")
    @GetMapping("twoArgs")
    public String twoParam(int i, String s) {
        return "cache two param😂" + i + s;
    }

    /**
     * <p>
     * 默认第一次查询 将会 把 ‘com.xu.springredis.controller.CacheTestHello+[参数]’作为key===》》》全类名+方法名+参数===》》》唯一标识。
     * 这是由 配置 {@link KeyGenerator}  规则产生的
     * 后续请求将直接取出value.
     * </p>
     *
     * @param i 参数
     * @return People
     */
    @GetMapping("hello")
    @Cacheable(value = "springCache")
    public People hello(int i) {
        return CacheTest.people(i);
    }


    @GetMapping("hello3")
    @Cacheable(value = {"name1", "name2"})
    public People hello3(int i) {
        return CacheTest.people(i);
    }

    /**
     * 使用了 EL 表达式
     * key:自定义key;condition:缓存条件 i>100
     *
     * @param i 参数
     * @return People
     */
    @Cacheable(value = "springCache2", key = "#i", condition = "#i>100")
    @GetMapping("hello2")
    public People hello2(int i, boolean b) {
        return CacheTest.people(i);
    }

    private static People people(int i) {
        People p = new People();
        if (i < 5) {
            p.setAge(18);
            p.setName("yan");
            return p;
        } else {
            p.setAge(18);
            p.setName("liu");
            return p;
        }
    }
}

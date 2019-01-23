package com.xu.springredis.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2018/8/8
 * com.xu.springRedis.controller
 * spring-practice
 */
@Controller
public class CacheTest3 {
    /**
     * 注意基于代理机制的AOP,使用方法内部调用无法缓存
     * 如下列：
     */
    @GetMapping("inner1")
    public void inner1() {
        inner2(8);
    }

    @Cacheable(cacheNames = "inner2")
    @GetMapping("inner2")
    public int inner2(int i) {
        System.out.println(i);
        return i;
    }
}

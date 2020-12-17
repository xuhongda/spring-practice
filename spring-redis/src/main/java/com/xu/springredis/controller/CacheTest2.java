package com.xu.springredis.controller;

import com.xu.pojo.People;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xuhongda on 2018/8/7
 * com.xu.springredis.controller
 * spring-practice
 */
@RequestMapping("CacheTest2")
@RestController
public class CacheTest2 {
    /**
     * 每次请求都会更新缓存值
     */
    @CachePut(cacheNames = "test2", key = "#i")
    @GetMapping("put")
    public People put(int i, boolean b) {
        if (b) {
            return new People(18, "yan");
        }
        return new People(18, "xuhongda");
    }

    /**
     * 删除 key
     * <p>
     *     注意问题 @CacheEvict 有beforeInvocation 属性默认值为false 表示方法
     *     执行后缓存才会删除，但是如果方法发送异常的话会导致缓存删除不成功
     * </p>
     */
    @CacheEvict(cacheNames = "test2", key = "#i", beforeInvocation = true)
    @GetMapping("delete")
    public String delete(int i) {
        return "delete" + i;
    }
}

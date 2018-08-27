package com.xu.springredis.controller;

import com.xu.pojo.People;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.springredis.controller
 * spring-practice
 */
@RestController
public class CacheTest2 {
    /**
     * 每次请求都会更新缓存值
     * @param i
     * @param b
     * @return
     */
    @CachePut(cacheNames = "test2",key = "#i")
    @GetMapping("put")
    public People put(int i,boolean b){
        if (b){
            return new People(18,"liulizhen");
        }
        return new People(18,"xuhongda");
    }

    /**
     * 删除 key
     * <p>
     *     注意问题 @CacheEvict 有beforeInvocation 属性默认值为false 表示方法
     *     执行后缓存才会删除，但是如果方法发送异常的话会导致缓存删除不成功
     * </p>
     * @param i
     * @return
     */
    @CacheEvict(cacheNames = "test2",key = "#i",beforeInvocation = true)
    @GetMapping("delet")
    public String delet(int i){
        return "delet i";
    }
}
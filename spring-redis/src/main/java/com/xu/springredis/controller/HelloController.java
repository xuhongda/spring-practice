package com.xu.springredis.controller;

import com.xu.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author xuhongda on 2018/9/26
 * com.xu.springredis.controller
 * spring-practice
 */
@Controller
public class HelloController {


    @Autowired
    KeyGenerator myKeyGenerator;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }


    @Cacheable(value = "ex",keyGenerator = "myKeyGenerator")
    @GetMapping("add")
    @ResponseBody
    public boolean add(Girl girl) {
        System.out.println(girl.toString());
        return true;
    }


    @CachePut(value = "ex",keyGenerator = "myKeyGenerator")
    @GetMapping("update")
    @ResponseBody
    public boolean update(Girl girl) {
        System.out.println(girl.toString());
        return true;
    }


    @CacheEvict(value = "ex",keyGenerator = "myKeyGenerator")
    @GetMapping("delete")
    @ResponseBody
    public boolean delete(Girl girl) {
        System.out.println(girl.toString());
        return true;
    }

    /**
     * 自定义 redis key 生成器
     * @return KeyGenerator
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("myKey");
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }
}

package com.xu.springcloudproducerhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudeurekacluster.controller
 * spring-practice
 */
@RestController
public class Hello {
    @GetMapping("hello")
    public String hello(@RequestParam String str){
        return str;
    }
}

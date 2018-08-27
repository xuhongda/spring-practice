package com.xu.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/8/10
 * com.xu.springcloudconfigclient.controller
 * spring-practice
 */
@RestController
public class HelloController {

    @Value("${xu.hello}")
    private String hello;

    @GetMapping("hello")
    public String hello(){
        return this.hello;
    }
}

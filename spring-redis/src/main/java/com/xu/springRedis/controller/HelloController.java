package com.xu.springredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2018/9/26
 * com.xu.springRedis.controller
 * spring-practice
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}

package com.xu.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2018/8/9
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class HelloController2 {
    @ResponseBody
    @GetMapping("hello2")
    public String hello2(String s1,String s2){
        return s1+s2;
    }
}

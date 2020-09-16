package com.xu.springbootweb.controller;

import com.xu.pojo.Girl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2018/8/9
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class HelloController2 {



    @ResponseBody
    @GetMapping(value = "hello1")
    public String hello1(String s1,String s2){
        return s1+s2;
    }

    @ResponseBody
    @PostMapping(value = "hello2",consumes = "application/x-www-form-urlencoded")
    public String hello2(String s1,String s2){
        return s1+s2;
    }


    @ResponseBody
    @GetMapping(value = "getGirl")
    public Girl getGirl(String name){
        Girl girl = new Girl();
        girl.setAge("18");
        girl.setName(name);
        return girl;
    }



}

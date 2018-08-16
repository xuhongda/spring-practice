package com.xu.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2018/8/8
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("hello")
    public String hello(String s){



        return s;
    }



    @ResponseBody
    @GetMapping("/hello/{ma}")
    public String hello2(String s1,String s2,@MatrixVariable(value = "mm",pathVar = "ma") int i){
        return s1+s2+i;
    }

    @GetMapping("/test")
    public String test(){
        return "wiredjs";
    }
}

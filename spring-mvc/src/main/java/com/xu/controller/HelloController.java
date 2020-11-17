package com.xu.controller;

import com.xu.core.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.controller
 * spring-practice
 */
@RestController
public class HelloController {

    @MyAnnotation
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("tt")
    public String tt(){
        return "tt";
    }

}

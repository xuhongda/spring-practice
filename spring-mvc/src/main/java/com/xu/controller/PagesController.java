package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.controller
 * spring-practice
 */
@Controller
public class PagesController {

    @GetMapping("t")
    public String hello(){
        return "hello";
    }
}

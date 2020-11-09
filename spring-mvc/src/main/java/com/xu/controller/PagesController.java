package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("view")
    public String view(HttpServletRequest request){
        request.setAttribute("param","123");
        return "view";
    }
}

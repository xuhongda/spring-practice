package com.xu.controller;

import com.xu.core.MyAnnotation;
import com.xu.pojo.Girl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.controller
 * spring-practice
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Girl girl2;

    @MyAnnotation
    @GetMapping("hello")
    public String hello(@RequestParam(required = false,defaultValue = "dd") String param){
        log.info("param = {}",param);
        return param;
    }

    @GetMapping("tt")
    public String tt(){
        System.out.println(girl2.getName()+girl2.getAge());
        return "tt";
    }

}

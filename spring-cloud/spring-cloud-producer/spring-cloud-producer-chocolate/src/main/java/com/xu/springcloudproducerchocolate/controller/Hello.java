package com.xu.springcloudproducerchocolate.controller;

import com.xu.pojo.Girl;
import com.xu.springcloudproducerchocolate.service.impl.GetGirlImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private GetGirlImpl getGirl;

    @GetMapping("hello")
    public String hello(@RequestParam String str){
        return str;
    }

    @GetMapping("girl")
    public Girl hello2(){
        return getGirl.meet();
    }
}

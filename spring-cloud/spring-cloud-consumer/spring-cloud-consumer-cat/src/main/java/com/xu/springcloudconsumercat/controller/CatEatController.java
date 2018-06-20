package com.xu.springcloudconsumercat.controller;

import com.xu.pojo.Girl;
import com.xu.springcloudconsumercat.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudconsumercat.controller
 * spring-practice
 */
@RestController
public class CatEatController {
    @Autowired
    private HelloRemote helloRemote;
    @RequestMapping("cateat")
    public String cateat(String str){
        return helloRemote.hello(str);
    }

    @RequestMapping("catlove")
    public Girl catlove(){
        return helloRemote.meetGirl();
    }

}

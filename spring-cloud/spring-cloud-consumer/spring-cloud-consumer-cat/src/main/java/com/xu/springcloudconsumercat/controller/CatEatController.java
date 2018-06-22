package com.xu.springcloudconsumercat.controller;

import com.xu.pojo.Girl;
import com.xu.springcloudconsumercat.remote.ChocolateRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudconsumercat.controller
 * spring-practice
 */
@RestController
public class CatEatController {
    @Autowired
    private ChocolateRemote chocolateRemote;
    @RequestMapping(value = "cateat")
    public String cateat(String str){
        return chocolateRemote.hello(str);
    }

    @RequestMapping(value = "catlove")
    public Girl catlove(){
        return chocolateRemote.meetGirl();
    }

}

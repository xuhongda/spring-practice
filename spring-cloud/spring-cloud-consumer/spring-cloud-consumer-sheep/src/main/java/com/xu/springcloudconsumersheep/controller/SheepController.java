package com.xu.springcloudconsumersheep.controller;

import com.xu.springcloudconsumersheep.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/6/21
 * com.xu.springcloudconsumersheep.controller
 * spring-practice
 */
@RestController
public class SheepController {
    @Autowired
    private HelloRemote helloRemote;
    @RequestMapping("eat/{grass}")
    public String eatGrass(@PathVariable("grass") String grass){
        return helloRemote.hello(grass);
    }
}

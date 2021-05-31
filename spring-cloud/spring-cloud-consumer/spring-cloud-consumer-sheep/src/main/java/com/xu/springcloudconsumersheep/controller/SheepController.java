package com.xu.springcloudconsumersheep.controller;

import com.xu.springcloudconsumersheep.remote.CakeRemote;
import com.xu.springcloudconsumersheep.remote.ChocolateRemote;
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
    private ChocolateRemote chocolateRemote;
    @Autowired
    private CakeRemote cakeRemote;

    @RequestMapping("eat/{grass}")
    public String eatGrass(@PathVariable("grass") String grass) {
        return chocolateRemote.hello(grass);
    }

    @RequestMapping("sweet/{grass}")
    public String eatCake(@PathVariable("grass") String grass) {
        return cakeRemote.foodpath(grass);
    }
}

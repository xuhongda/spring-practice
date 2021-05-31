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

    private final ChocolateRemote chocolateRemote;

    @Autowired
    public CatEatController(ChocolateRemote chocolateRemote) {
        this.chocolateRemote = chocolateRemote;
    }

    @RequestMapping(value = "catEat")
    public String catEat(String str) {
        return chocolateRemote.hello(str);
    }

    @RequestMapping(value = "catLove")
    public Girl catLove() {
        return chocolateRemote.meetGirl();
    }

}

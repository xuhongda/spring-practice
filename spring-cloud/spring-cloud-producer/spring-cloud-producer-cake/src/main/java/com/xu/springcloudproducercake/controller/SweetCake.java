package com.xu.springcloudproducercake.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda 2018/6/22
 * com.xu.springcloudproducercake.controller
 * spring-practice
 */
@RestController
public class SweetCake {
    @GetMapping("sweet/{path}")
    public String path(@PathVariable("path") String path){
        return path;
    }
}

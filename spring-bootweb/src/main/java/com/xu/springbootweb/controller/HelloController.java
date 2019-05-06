package com.xu.springbootweb.controller;

import com.xu.pojo.Girl;
import com.xu.pojo.People;
import com.xu.springbootweb.bean.Dog;
import com.xu.springbootweb.bean.DogTest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuhongda on 2018/8/8
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller

public class HelloController {

    @Autowired
    private DogTest dogTest;

    @GetMapping("swagger")
    public String swagger(){
        return "redirect:swagger-ui.html";
    }
    @ResponseBody
    @GetMapping("hello")
    public String hello(@RequestParam int age,@RequestParam  String name){
        return age+name;
    }

    /**
     * <p>@RequestBody 把json 格式的字符串变成对象</p>
     * @param people
     * @param host
     * @param type
     * @return
     */
    @ResponseBody
    @PostMapping("/json")
    public String json(@RequestBody People people,@RequestHeader("Host") String host,@RequestHeader("Content-Type") String type){
        System.out.println(people);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        String format1 = format.format(new Date());
        return people.toString()+"\t"+host+"\t"+type+"\t"+format1;
    }

    @GetMapping("socket")
    public String socket(){
        return "socket";
    }

    @ResponseBody
    @PostMapping("xhr")
    public String xhr(@RequestParam String name,@RequestParam int age){
        System.err.println(name);
        return name+age+new Date().toString();
    }

    @GetMapping("/wiredjs")
    public String wiredjs(){
        return "wiredjs";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @ApiOperation("xx")
    @ApiImplicitParams(@ApiImplicitParam(name = "name", value = "姓名", dataType = "String"))
    @GetMapping("/girl")
    public Girl girl(Girl girl) {
        return girl;
    }

    @ResponseBody
    @GetMapping("/dog")
    public String getDof() {

        return dogTest.getDog().getName();
    }
}

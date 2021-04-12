package com.xu.springbootweb.controller;

import com.xu.pojo.Girl;
import com.xu.pojo.People;
import com.xu.springbootweb.bean.DogTest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
     */
    @ResponseBody
    @PostMapping("/json")
    public String json(@RequestBody People people,@RequestHeader(value = "Host",required = false) String host,@RequestHeader(value = "Content-Type",required = false) String type){
        log.info("people = {}",people);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date());
        return people.toString()+"\t"+host+"\t"+type+"\t"+format1;
    }

    @ResponseBody
    @PostMapping("xhr")
    public String xhr(@RequestParam String name,@RequestParam int age){
        System.err.println(name);
        return name+age+new Date().toString();
    }

    @ApiOperation("xx")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "姓名", dataType = "String",paramType = "query")
    ,@ApiImplicitParam(name="age",value = "年龄",dataType = "int",paramType = "query")
    ,@ApiImplicitParam(name ="lookLike",value = "外貌",dataType = "String",paramType = "query")}
    )
    @GetMapping("/girl")
    @ResponseBody
    public Girl girl(Girl girl) {
        return girl;
    }

    @ResponseBody
    @GetMapping("/dog")
    public String getDof() {

        return dogTest.getDog().getName();
    }

    @ResponseBody
    @PostMapping("login")
    public String login(String username,String password){

        return username + password;
    }


    @ResponseBody
    @PostMapping("changePassword")
    public String changePassword(String userName,String oldPassword,String newPassword){

        return userName + oldPassword + newPassword;
    }



    @ResponseBody
    @GetMapping(value = "hello1")
    public String hello1(String s1,String s2){
        return s1+s2;
    }

    @ResponseBody
    @PostMapping(value = "hello2",consumes = "application/x-www-form-urlencoded")
    public String hello2(String s1,String s2){
        return s1+s2;
    }


    @ResponseBody
    @PostMapping(value = "getGirl")
    public Girl getGirl(String name){
        Girl girl = new Girl();
        girl.setAge("18");
        girl.setName(name);
        return girl;
    }
}

package com.xu.springbootweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda on 2020/12/24
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class CarController {

    @ResponseBody
    @PostMapping("car")
    public String car(@RequestBody Map<String,String> map) throws JsonProcessingException {
        String key = map.get("key");
        System.out.println(key);
        List<String> list = new ArrayList<>();
        list.add(key);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
    }
}

package com.xu.springbootweb.controller;

import com.xu.pojo.Girl;
import com.xu.springbootweb.bean.YearCheckChangeAppointPojo;
import com.xu.springbootweb.bean.YearCheckPojo;
import com.xu.springbootweb.bean.YearCheckStatusPojo;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda on 2018/8/9
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class FileController {





    @ResponseBody
    @PostMapping(value = "/vai/syncOrderStatus")
    public Map getP(@RequestPart(required = false) List<MultipartFile> imgs, YearCheckStatusPojo statusPojo) throws IOException {

        System.out.println(statusPojo);

        for (MultipartFile file:imgs){

            File file1 = new File("D:\\xucode\\my\\spring-practice\\spring-bootweb\\src\\main\\resources"+"/"+file.getOriginalFilename());
            file.transferTo(file1);
        }

        Map<String,Object> map = new HashMap<>();
        map.put("result",0);
        map.put("resultNote","success");
        return map;
    }

    @ResponseBody
    @PostMapping(value = "/vai/changeAppoint")
    public Map changeAppoint(@RequestBody YearCheckChangeAppointPojo yearCheckChangeAppointPojo) throws IOException {

        System.out.println(yearCheckChangeAppointPojo);
        Map<String,Object> map = new HashMap<>();
        map.put("result",0);
        map.put("resultNote","success");
        return map;
    }



}

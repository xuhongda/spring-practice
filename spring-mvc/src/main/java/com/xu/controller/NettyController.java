package com.xu.controller;

import com.xu.netty.first.ServerTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2020/11/11
 * com.xu.controller
 * spring-practice
 */
@Controller
public class NettyController {
    @ResponseBody
    @RequestMapping("openNetty")
    public boolean openNetty(){
        try {
           boolean b = ServerTest.start();
           return b;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @ResponseBody
    @RequestMapping("closeNetty")
    public boolean closeNetty(){
        try {
            boolean close = ServerTest.close();
            return close;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

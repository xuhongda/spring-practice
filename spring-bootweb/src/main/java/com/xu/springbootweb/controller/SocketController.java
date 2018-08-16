package com.xu.springbootweb.controller;

import com.xu.springbootweb.component.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuhongda on 2018/8/15
 * com.xu.springbootweb.controller
 * spring-practice
 */
@Controller
public class SocketController {

    private static String sid ;

    @GetMapping("push/{sid}")
    public @ResponseBody String push(@PathVariable(name = "sid")String sid) throws IOException {
        System.out.println(sid);
        fuc(sid);
        return "success";
    }


    @Scheduled(fixedDelay = 1000)
    private void getDate() throws IOException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);
        WebSocketServer.sendInfo(format1,sid);
    }


    private void fuc(String cid) throws IOException {
        sid = cid;
        getDate();
    }

}

package com.xu.springbootweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.springbootweb.server.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    private Integer num = 0;
    @Scheduled(initialDelay = 5000,fixedDelay = 60*1000)
    private void getDate() throws IOException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
           /*hasIncreaseMsg:1,
                        msgCount: 91,
                        msgName: "车辆碰撞",
                        msgType: "1",
                        referJsp: "urgentEvent.html",*/
        Map<String,Object> map = new HashMap<>(10);
        map.put("alarmTime",time);
        map.put("hasIncreaseMsg",1);
        map.put("msgName","车辆碰撞");
        map.put("totoalNum",num++);
        map.put("msgType",1);
        map.put("referJsp","urgentEvent.html");
        map.put("lpno","融L5F95L");
        ObjectMapper mapper = new ObjectMapper();
        WebSocketServer.sendInfo(mapper.writeValueAsString(map),sid);
    }


    private void fuc(String cid) throws IOException {
        sid = cid;
        getDate();
        WebSocketServer.sendInfo("hello world!",sid);
    }

}

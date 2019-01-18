package com.xu.springRedis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author xuhongda on 2018/8/7
 * com.xu.springRedis.controller
 * spring-practice
 */
@RestController
public class SessionTest {
    @GetMapping("test")
    public String test(HttpSession httpSession){
        UUID uid = (UUID)httpSession.getAttribute("test");
        if (uid == null){
            uid = UUID.randomUUID();
        }
        httpSession.setAttribute("test",uid);
        return httpSession.getId();
    }
}

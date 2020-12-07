package com.xu.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.core
 * spring-practice
 */
@Slf4j
@Component
public class MyListener {



    @EventListener
    public void myView(MyViewEvent myViewEvent) {
         myViewEvent.record();
    }
}

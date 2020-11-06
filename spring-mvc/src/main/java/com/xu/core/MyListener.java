package com.xu.core;


import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.core
 * spring-practice
 */
@Slf4j
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       log.info("start");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

package com.xu.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author xuhongda on 2020/11/16
 * com.xu.core
 * spring-practice
 */
@Slf4j
@Component
public class ListenerByAnnotation {

    @EventListener
    public void requestEvent(ServletRequestHandledEvent requestHandledEvent){
        log.info("ListenerByAnnotation = {}",requestHandledEvent.getDescription());
    }
}

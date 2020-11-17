package com.xu.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author xuhongda on 2020/11/16
 * com.xu.core
 * spring-practice
 */
@Slf4j
@Component
public class ServeletRequestListener implements ApplicationListener<ServletRequestHandledEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        log.info("event = {}",event.getShortDescription());
    }
}

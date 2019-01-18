package com.xu.service.impl;

import com.xu.service.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * @author xuhongda on 2018/5/21
 * com.xu.service.impl
 * spring-quartz-task
 */
@Service
public class TaskImpl implements Task {
    @Scheduled(fixedRate = 10000)
    @Override
    public void doIt() {
        System.out.println("这是一个基于注解的定时任务");
    }

}

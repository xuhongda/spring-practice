package com.xu.service.impl;

import com.xu.service.Task;


/**
 * @author xuhongda on 2018/5/21
 * com.xu.service.impl
 * spring-quartz-task
 */
public class TaskNoAnoImpl implements Task {
    @Override
    public void doIt() {
        System.out.println("这是一个无注解的定时任务");
    }
}

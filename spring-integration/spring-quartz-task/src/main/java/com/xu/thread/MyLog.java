package com.xu.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2018/5/21
 * com.xu.thread
 * spring-quartz-task
 */
@Service
public class MyLog {
    @Autowired
    private ThreadPoolTaskExecutor logExecutor;

    public void a() {
        logExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        });
    }

}

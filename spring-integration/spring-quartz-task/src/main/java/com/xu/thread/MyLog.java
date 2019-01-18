package com.xu.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2018/5/21
 * com.xu.thread
 * spring-quartz-task
 */
@Service
@Slf4j
public class MyLog {

    private final ThreadPoolTaskExecutor logExecutor;

    @Autowired
    public MyLog(ThreadPoolTaskExecutor logExecutor) {
        this.logExecutor = logExecutor;
    }

    public void a() {
        logExecutor.execute(() -> log.info("thread"));
    }

}

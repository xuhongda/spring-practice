package com.xu.springcloudconsumersheep.remote;

import org.springframework.stereotype.Component;

/**
 * @author xuhongda 2018/6/22
 * com.xu.springcloudconsumersheep.remote
 * spring-practice
 */
@Component
public class CakeRemoteHystrix implements CakeRemote {
    @Override
    public String foodpath(String path) {
        return "断路";
    }
}

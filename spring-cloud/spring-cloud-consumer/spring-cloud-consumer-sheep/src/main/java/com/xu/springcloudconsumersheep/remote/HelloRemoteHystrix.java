package com.xu.springcloudconsumersheep.remote;

import com.xu.pojo.Girl;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda 2018/6/21
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String str) {
        return "消息调用失败";
    }

    @Override
    public Girl meetGirl() {
        return new Girl("美若天仙","迪丽热巴","18");
    }
}

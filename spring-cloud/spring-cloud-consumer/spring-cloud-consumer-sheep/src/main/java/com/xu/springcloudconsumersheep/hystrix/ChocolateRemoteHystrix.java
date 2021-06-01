package com.xu.springcloudconsumersheep.hystrix;

import com.xu.pojo.Girl;
import com.xu.springcloudconsumersheep.remote.ChocolateRemote;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda 2018/6/21
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
@Component
public class ChocolateRemoteHystrix implements ChocolateRemote {
    @Override
    public String hello(String str) {
        return "消息调用失败";
    }

    @Override
    public Girl meetGirl() {
        return new Girl("美若天仙", "迪丽热巴", "18");
    }

    @Override
    public String foodPath(String path) {
        return null;
    }
}

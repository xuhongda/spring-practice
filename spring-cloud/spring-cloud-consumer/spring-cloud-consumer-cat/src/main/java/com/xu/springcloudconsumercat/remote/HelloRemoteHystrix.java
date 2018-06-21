package com.xu.springcloudconsumercat.remote;

import com.xu.pojo.Girl;

/**
 * @author xuhongda 2018/6/21
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
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

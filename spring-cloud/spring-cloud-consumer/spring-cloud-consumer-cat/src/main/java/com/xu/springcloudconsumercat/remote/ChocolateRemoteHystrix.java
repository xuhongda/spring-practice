package com.xu.springcloudconsumercat.remote;

import com.xu.pojo.Girl;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     需要加入spring容器，不要忘记@@Component注解，否则会启动失败，报不安全依赖异常
 * </p>
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
        return new Girl("美若天仙","迪丽热巴","18");
    }
}

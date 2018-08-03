package com.xu.springcloudconsumersheep.remote;

import com.xu.pojo.Girl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *     @FeignClient name:指定远程服务名称 fallback:服务调用失败断路
 *     @RequestMapping value 与远程 Controller mapping名称对应
 *     fallback指定断路类
 *
 * </p>
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
@FeignClient(name= "spring-cloud-producer-chocolate",fallback = ChocolateRemoteHystrix.class)
public interface ChocolateRemote {
    /**
     * hello
     * @param str <p>@RequestParam 必须加value</p>
     * @return
     */
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String hello(@RequestParam(value = "str") String str);

    /**
     * 获取一个女孩
     * @return
     */
    @RequestMapping(value = "girl",method = RequestMethod.GET)
    Girl meetGirl();
}

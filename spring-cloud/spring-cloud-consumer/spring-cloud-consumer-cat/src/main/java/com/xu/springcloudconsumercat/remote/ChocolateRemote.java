package com.xu.springcloudconsumercat.remote;

import com.xu.pojo.Girl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;

/**
 * <p>
 *     @FeignClient name:指定远程服务名称 fallback:服务调用失败断路
 *     @RequestMapping value 与远程 Controller mapping名称对应
 * </p>
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
@FeignClient(name= "spring-cloud-producer-chocolate",fallback = ChocolateRemoteHystrix.class)
public interface ChocolateRemote {
    /**
     * hello
     * @param str
     * @return String
     */
    @RequestMapping(value = "hello")
    String hello(@RequestParam(value = "str") String str);

    /**
     * 获取一个女孩
     * @return Girl
     */
    @RequestMapping(value = "girl")
    Girl meetGirl();
}

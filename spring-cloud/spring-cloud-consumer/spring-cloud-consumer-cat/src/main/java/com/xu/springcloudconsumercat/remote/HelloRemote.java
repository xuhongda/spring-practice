package com.xu.springcloudconsumercat.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudconsumercat.remote
 * spring-practice
 */
@FeignClient(name= "spring-cloud-producer-server")
public interface HelloRemote {
    /**
     * hello
     * @param str
     * @return
     */
    @RequestMapping("hello")
    String hello(@RequestParam(value = "str") String str);
}

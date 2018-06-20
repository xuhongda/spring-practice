package com.xu.springcloudconsumercat.remote;

import com.xu.pojo.Girl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *     @FeignClient 指定远程服务名称
 *     @RequestMapping value 与远程 Controller mapping名称对应
 * </p>
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

    /**
     * 获取一个女孩
     * @return
     */
    @RequestMapping("girl")
    Girl meetGirl();
}

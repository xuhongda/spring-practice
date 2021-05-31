package com.xu.springcloudconsumersheep.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xuhongda 2018/6/22
 * com.xu.springcloudconsumersheep.remote
 * spring-practice
 */
@FeignClient(value = "spring-cloud-producer-cake", fallback = CakeRemoteHystrix.class)
public interface CakeRemote {
    /**
     * sheetEatCake
     * 接口名是否需要与生产者 controller 名相同？不需要
     * 只需要 @RequestMapping 路径一致
     *
     * @param path
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "sweet/{path}")
    String foodpath(@PathVariable(value = "path") String path);
}

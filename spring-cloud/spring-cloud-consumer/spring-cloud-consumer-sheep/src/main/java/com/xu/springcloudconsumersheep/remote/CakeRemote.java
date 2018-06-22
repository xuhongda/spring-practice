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
@FeignClient(value ="spring-cloud-producer-cake" )
public interface CakeRemote {
    @RequestMapping(method = RequestMethod.GET,value = "sweet/{path}")
    String sheetEatCake(@PathVariable(value = "path") String path);
}

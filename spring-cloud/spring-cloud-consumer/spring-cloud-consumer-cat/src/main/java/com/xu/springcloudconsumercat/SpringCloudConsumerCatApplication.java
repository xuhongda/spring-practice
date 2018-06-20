package com.xu.springcloudconsumercat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudConsumerCatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerCatApplication.class, args);
    }
}

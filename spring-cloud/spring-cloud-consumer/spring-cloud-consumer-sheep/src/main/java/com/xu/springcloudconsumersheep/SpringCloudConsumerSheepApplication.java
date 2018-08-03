package com.xu.springcloudconsumersheep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>
 *     @EnableDiscoveryClient 启用服务的注册与发现
 *     @EnableFeignClients 启用feign进行远程调用
 *     @EnableHystrixDashboard 启用Hystrix Dashboard和熔断器
 * </p>
 * @author xuhongda
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringCloudConsumerSheepApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerSheepApplication.class, args);
    }
}

package com.xu.springcloudconsumersheep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 *
 * @author xuhongda
 * <p>@EnableDiscoveryClient 启用服务的注册与发现</p>
 * <p>@EnableFeignClients 启用feign进行远程调用</p>
 * <p>@EnableHystrixDashboard 启用Hystrix Dashboard和熔断器</p>
 * </p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringCloudConsumerSheepApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerSheepApplication.class, args);
    }
}

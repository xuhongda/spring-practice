package com.xu.springcloudproducerchocolate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProducerChocolateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerChocolateApplication.class, args);
    }
}

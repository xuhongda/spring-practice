package com.xu.springcloudproducerchocolate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProducerChocolateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerChocolateApplication.class, args);
    }
}

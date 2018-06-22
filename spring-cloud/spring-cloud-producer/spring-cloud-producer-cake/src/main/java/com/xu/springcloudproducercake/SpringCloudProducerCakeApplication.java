package com.xu.springcloudproducercake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProducerCakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerCakeApplication.class, args);
    }
}

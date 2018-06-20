package com.xu.springcloudproducerhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProducerHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerHelloApplication.class, args);
    }
}

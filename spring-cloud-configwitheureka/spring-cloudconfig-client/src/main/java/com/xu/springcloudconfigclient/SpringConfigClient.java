package com.xu.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringConfigClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigClient.class, args);
    }
}

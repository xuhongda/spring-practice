package com.xu.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author xuhongda
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SpringCloudconfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudconfigServerApplication.class, args);
    }
}

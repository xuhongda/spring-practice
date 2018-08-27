package com.xu.springcloudeurekacluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xuhongda
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClusterApplication.class, args);
    }
}

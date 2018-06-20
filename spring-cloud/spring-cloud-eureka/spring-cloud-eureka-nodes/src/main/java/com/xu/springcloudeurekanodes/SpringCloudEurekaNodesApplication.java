package com.xu.springcloudeurekanodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaNodesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaNodesApplication.class, args);
    }
}

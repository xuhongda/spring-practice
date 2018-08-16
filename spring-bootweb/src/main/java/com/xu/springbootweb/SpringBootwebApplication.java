package com.xu.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xuhongda
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootwebApplication.class, args);
    }
}

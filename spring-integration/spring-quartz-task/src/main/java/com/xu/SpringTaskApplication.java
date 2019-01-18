package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author xuhongda on 2019/1/18
 * com.xu
 * spring-practice
 */
@SpringBootApplication
@ImportResource("spring-task.xml")
public class SpringTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringTaskApplication.class);
    }
}

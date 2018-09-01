package com.xu.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xuhongda
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class SpringBootwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootwebApplication.class, args);
    }
}

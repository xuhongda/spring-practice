package com.xu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xuhongda on 2020/11/24
 * com.xu.pojo
 * spring-practice
 */
@Data
@Component
public class Cat {
    @Value("hello kitty")
    private String name;

    public Cat() {

        System.out.println("init cat");
    }

    public Cat(String name) {
        this.name = name;
        System.out.println(2);
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");
        System.out.println(name);
    }
}

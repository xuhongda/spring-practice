package com.xu.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xuhongda on 2020/11/24
 * com.xu.pojo
 * spring-practice
 */
@Data
@Component
public class Tiger {

    private String name;

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct tiger");
    }
}

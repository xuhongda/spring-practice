package com.xu.springbootweb.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2019/5/6
 * com.xu.springbootweb.bean
 * spring-practice
 */
@Service
public class DogTest {

    @Autowired
    private Dog dog;

    public Dog getDog(){
        return dog;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("static/spring/spring.xml");
        Object dog = ctx.getBean("dog");
        System.out.println(dog);

        DogTest dogTest = new DogTest();
        String name = dogTest.getDog().getName();
        System.out.println(name);
    }
}

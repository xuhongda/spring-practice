package com.xu.test;

import com.xu.core.MyViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.test
 * spring-practice
 */
public class ApplicationTest {

    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-mvc.xml");
        MyViewResolver resolver = (MyViewResolver)context.getBean("myViewResolver");
        System.out.println(resolver.getOrder());
    }
}

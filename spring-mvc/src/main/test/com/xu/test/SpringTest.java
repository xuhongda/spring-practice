package com.xu.test;

import com.xu.core.MyAnnotation;
import com.xu.core.MyViewResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.test
 * spring-practice
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-config.xml"})
public class SpringTest {

    @Autowired
    private MyViewResolver myViewResolver;

    @Test
    public void test001(){
       int order = myViewResolver.getOrder();
        System.out.println(order);
    }


    @Test
    public void test002(){
        Class<MyAnnotation> myAnnotationClass = MyAnnotation.class;
        Annotation annotation = myAnnotationClass.getAnnotation(java.lang.annotation.Target.class);

        System.out.println(annotation);

    }
}

package com.xu.core;

import java.lang.annotation.*;

/**
 * @author xuhongda on 2020/11/17
 * com.xu.core
 * spring-practice
 * <P>自定义注解</P>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String name() default "xuhongda";
}

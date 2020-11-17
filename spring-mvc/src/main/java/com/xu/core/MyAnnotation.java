package com.xu.core;



import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author xuhongda on 2020/11/17
 * com.xu.core
 * spring-practice
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String name() default "xuhongda";
}

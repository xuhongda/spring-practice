package com.xu.core.aspect;

import com.xu.core.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;




/**
 * @author xuhongda on 2020/11/17
 * com.xu.core.aspect
 * spring-practice
 */
@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyAroundAop {


    @Before("execution(* com.xu.controller.HelloController.*(..))")
    public void before(){
        System.out.println("before");
    }


    @Around(value = "@annotation(com.xu.core.MyAnnotation)")
    public String xx(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

        if (annotation != null){
            String name = annotation.name();
            System.out.println(name);
            if ("xuhongda".equals(name)){
                log.info("xuhongda & liulizhen");
            }
            return name;
        }
        return null;
    }
}

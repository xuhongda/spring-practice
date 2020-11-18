package com.xu.core.aspect;

import com.xu.core.MyAnnotation;
import com.xu.pojo.Constants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


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



    @Autowired
    private ApplicationContext context;

    @Before("execution(* com.xu.controller.HelloController.*(..))")
    public void before(){
        System.out.println("before");
    }

    /**
     *  解析自定义注解
     *  环绕切面两大要素：ProceedingJoinPoint 参数 和 返回 Object
     */
    @Around(value = "@annotation(com.xu.core.MyAnnotation)")
    public Object xx(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

        if (annotation != null){
            String name = annotation.name();
            System.out.println(name);
            if (Constants.ME.getValue().equals(name)){
                log.info("xuhongda & liulizhen");
            }
            Parameter[] parameters = method.getParameters();
            for (Parameter p:parameters){
                System.out.println(p.getParameterizedType());
            }

            String[] args = {"xx"};
            //执行目标方法
            Object proceed = joinPoint.proceed(args);
           /* ApplicationEvent event = new ContextStoppedEvent(context);
            context.publishEvent(event);*/
            log.info("around end");
            return proceed;

        }
        return null;
    }
}

package com.xu.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import java.util.Locale;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
@Slf4j
public class MyViewResolver implements ViewResolver, Ordered {


    private Integer order;


    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        System.out.println(viewName);
        if ("view".equals(viewName)){
            return new MyView();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public void setOrder(Integer order){
        this.order = order;

    }
}

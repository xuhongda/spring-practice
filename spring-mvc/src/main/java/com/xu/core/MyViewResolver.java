package com.xu.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.applet.AppletContext;
import java.util.Locale;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
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

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 1;
    }

    public void setOrder(Integer order){
        this.order = order;

    }
}

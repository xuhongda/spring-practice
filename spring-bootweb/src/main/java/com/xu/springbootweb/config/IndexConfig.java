package com.xu.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xuhongda on 2018/8/21
 * com.xu.springbootweb.config
 * spring-practice
 */
@Configuration
public class IndexConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("socket").setViewName("socket");
        registry.addViewController("wiredjs").setViewName("wiredjs");
        registry.addViewController("test").setViewName("test");
        registry.addViewController("test").setViewName("test");
        super.addViewControllers(registry);
    }



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}

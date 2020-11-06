package com.xu.core;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xuhongda on 2020/11/6
 * com.xu.core
 * spring-practice
 */
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("true");
        chain.doFilter(request,response);
    }


    @Override
    public void destroy() {

    }
}

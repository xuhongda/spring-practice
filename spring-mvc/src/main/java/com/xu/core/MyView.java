package com.xu.core;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
public class MyView implements View {



    @Override
    public String getContentType() {
        return "text/html";
    }


    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(model);
        String attribute = (String) request.getAttribute("param");
        System.out.println(attribute);
        response.setContentType("text/html");
        response.getWriter().write("<h1>hello<h1>");
    }
}

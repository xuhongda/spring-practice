package com.xu.core;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import java.util.Locale;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
public class MyViewResolver implements ViewResolver, Ordered {


    private Integer order;


    /**
     * Resolve the given view by name.
     * <p>Note: To allow for ViewResolver chaining, a ViewResolver should
     * return {@code null} if a view with the given name is not defined in it.
     * However, this is not required: Some ViewResolvers will always attempt
     * to build View objects with the given name, unable to return {@code null}
     * (rather throwing an exception when View creation failed).
     *
     * @param viewName name of the view to resolve
     * @param locale   Locale in which to resolve the view.
     *                 ViewResolvers that support internationalization should respect this.
     * @return the View object, or {@code null} if not found
     * (optional, to allow for ViewResolver chaining)
     * @throws Exception if the view cannot be resolved
     *                   (typically in case of problems creating an actual View object)
     */
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

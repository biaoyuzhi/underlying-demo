package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wuzh on 2019/10/17.
 * Describe：实现的Filter接口来自servlet-api依赖包
 *          1、Springmvc中除了定义下面类外，还需在web.xml中增加配置：
 *          <filter>
 *          <filter-name>MyFilter</filter-name>
 *          <filter-class>filter.MyFilter</filter-class>
 *          </filter>
 *          <filter-mapping>
 *          <filter-name>MyFilter</filter-name>
 *          <url-pattern>/*</url-pattern>
 *          </filter-mapping>
 *          2、SpringBoot中除了定义下面类外，还需创建一个配置类@Configuration将MyFilter注入：
 *          @Configuration
 *          public class FilterConfig {
 *              @Bean
 *              public FilterRegistrationBean registrationMyFilter() {
 *                  FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
 *                  filterRegistrationBean.setFilter(new MyFilter());   //注册的是哪个过滤器
 *                  List<String> urls = new ArrayList<>();
 *                  urls.add("/*");
 *                  filterRegistrationBean.setUrlPatterns(urls);        //配置过滤规则
 *                  filterRegistrationBean.setOrder(1);                 //设置过滤器优先级
 *                  return filterRegistrationBean;
 *              }
 *          }
 */
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest)servletRequest;
        Proxy.newProxyInstance(MyFilter.class.getClassLoader(), MyFilter.class.getInterfaces(), new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (!method.getName().equals("getParameter") && !request.getMethod().equalsIgnoreCase("get")){
                    return method.invoke(request,args);
                }
                String invoke = (String) method.invoke(request, args);
                if (invoke == null) return null;
                return new String(invoke.getBytes("iso8859-1"),"utf-8");
            }
        });
    }

    public void destroy() {

    }
}

package dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：实现CGLib动态代理类
 */
public class CGLibDynamicProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        //设置父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        enhancer.setUseCache(false);
        return enhancer.create();
    }

    /**
     * @param o             目标对象
     * @param method        目标方法
     * @param args          目标方法的参数
     * @param methodProxy   代理类
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib动态代理前");
        Object invoke = methodProxy.invokeSuper(o,args);
        System.out.println("CGLib动态代理前");
        return invoke;
    }
}

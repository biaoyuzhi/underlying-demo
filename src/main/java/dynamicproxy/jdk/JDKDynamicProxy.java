package dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：实现JDK动态代理类
 */
public class JDKDynamicProxy implements InvocationHandler {
    //需要代理的对象类
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * @param proxy     代理对象
     * @param method    被代理对象的方法
     * @param args      被代理对象的方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理前");
        Object invoke = method.invoke(target, args);
        System.out.println("JDK动态代理前");
        return invoke;
    }
}

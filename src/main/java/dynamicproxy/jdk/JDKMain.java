package dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：
 */
public class JDKMain {
    public static void main(String[] args) {
        JDKTargetImp targetImp = new JDKTargetImp();
        JDKDynamicProxy proxy = new JDKDynamicProxy(targetImp);
        JDKTarget instance = (JDKTarget) Proxy.newProxyInstance(targetImp.getClass().getClassLoader(), targetImp.getClass().getInterfaces(), proxy);
        instance.request();
    }
}

package dynamicproxy.cglib;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：被代理对象类
 */
public class CGLibTarget {
    public void request(){
        System.out.println("cglib被代理类的请求方法");
    }
}

package dynamicproxy.cglib;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：
 */
public class CGLibMain {
    public static void main(String[] args) {
        CGLibDynamicProxy proxy = new CGLibDynamicProxy();
        CGLibTarget instance = (CGLibTarget) proxy.getProxy(CGLibTarget.class);
        instance.request();
    }
}

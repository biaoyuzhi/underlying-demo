package dynamicproxy.jdk;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：被代理对象实现类
 */
public class JDKTargetImp implements JDKTarget{
    public void request() {
        System.out.println("jdk被代理类的请求方法");
    }
}

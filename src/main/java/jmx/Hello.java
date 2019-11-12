package jmx;

/**
 * Created by wuzh on 2019/11/12.
 * Describe:
 */
public class Hello implements HelloMBean {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("空参构造器");
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("带的参数是：" + whoName);
    }

    @Override
    public String printName() {
        return name;
    }
}

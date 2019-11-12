package jmx;

/**
 * Created by wuzh on 2019/11/12.
 * Describe:
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);

    public String printName();
}

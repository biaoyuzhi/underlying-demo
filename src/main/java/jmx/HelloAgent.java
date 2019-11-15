package jmx;

import org.springframework.web.WebApplicationInitializer;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * Created by wuzh on 2019/11/12.
 * Describe: JMX的全称为Java Management Extensions. 顾名思义，是管理Java的一种扩展。
 * 这种机制可以方便的管理、监控正在运行中的Java程序。常用于管理线程，内存，日志Level，服务重启，系统环境等。
 * 参考https://blog.csdn.net/u013256816/article/details/52800742
 * 实现SpringMVC的WebApplicationInitializer接口，此类在servlet容器启动时加载
 */
public class HelloAgent implements WebApplicationInitializer {
    //将对象hello暴露出来，方便其它地方调用
    public static Hello hello = new Hello();

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        start();
    }

    public void start() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            String domainName = "MyMBean";
            ObjectName helloName = new ObjectName(domainName + ":name=hello");
            mbs.registerMBean(hello, helloName);

            // Distributed Layer, 提供了一个HtmlAdaptor。支持Http访问协议，并且有一个不错的HTML界面，这里的Hello就是用这个作为远端管理的界面
            // 事实上HtmlAdaptor是一个简单的HttpServer，它将Http请求转换为JMX Agent的请求
            // HtmlAdaptorServer类需要用到jmxtools.jar
//        ObjectName adapterName = new ObjectName(domainName+":name=htmladapter,port=8082");
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        adapter.start();
//        mbs.registerMBean(adapter,adapterName);

            int rmiPort = 1099;
            LocateRegistry.createRegistry(rmiPort); //在某一特定端口创建名字服务，从而用户无需再手工启动rmiregistry

            // 通过RMI(JMXServiceURL, JMXConnectorServer )注册URL来提供客户端连接，可以通过JConsole作为客户端来管理MBean
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:" + rmiPort + "/" + domainName);
            JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
            jmxConnector.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

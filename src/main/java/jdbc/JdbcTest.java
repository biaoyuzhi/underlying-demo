package jdbc;

import java.sql.*;

/**
 * Created by wuzh on 2019/11/20.
 * Describe: Java 6 开始支持 JDBC 4.0 的一系列新功能和属性
 * JDBC 4.0 的规范规定，所有 JDBC 4.0 的驱动 jar 文件必须包含一个java.sql.Driver文件，它位于jar文件的META-INF/services目录下。这个文件里每一行便描述了一个对应的驱动类
 * 在启动项目或是服务时，会判断当前classspath中的所的jar包，并检查他们META-INF目录下，是否包含services文件夹，如果包含，就会将里面的配置加载成相应的服务。
 *
 * 从JDBC4.0开始，就不在需要主动的显式注册启动了。即：Class.forName("xxx")这行可以省去。
 * 在调用DriverManager.getConnection()方法时，DriverManager的静态代码块中loadInitialDrivers()方法会完成驱动程序的加载。
 *
 * loadInitialDrivers()主要做了两件事情：
 * 读取系统属性jdbc.drivers，如果存在将会进行加载。
 * 检查jar包中的META-INF/services，如果有那么会自动注册，服务注册依赖的是ServiceLoader.load(Driver.class)。
 *
 * DriverManager类中将已经注册的驱动registeredDrivers放在一个特殊的集合中：CopyOnWriteArrayList<DriverInfo>。
 * CopyOnWriteArrayList是ArrayList的线程安全版本，它在有写操作的时候会copy一份数据，然后写完再设置成新的数据。CopyOnWriteArrayList适用于读多写少的并发场景
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception {
        //注册自定义的驱动
        Class.forName("jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:wuzh://localhost:3306/web1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
        System.out.println(conn.toString());
        Statement statement = conn.createStatement();
        System.out.println(statement.toString());
        ResultSet resultSet = statement.executeQuery("");
    }
}

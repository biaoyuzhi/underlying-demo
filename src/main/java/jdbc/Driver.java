package jdbc;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuzh on 2019/11/20.
 * Describe: 自定义驱动
 */
public class Driver implements java.sql.Driver {
    //这是mysql的jdbc驱动中的url匹配正则表达式
    private static final Pattern SCHEME_PTRN = Pattern.compile("(?<scheme>[\\w:%]+).*");
    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    public  Driver(){}
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (acceptsURL(url)) return new ConnectionImpl(url,info);
        throw new RuntimeException("url不符");
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        Matcher matcher = SCHEME_PTRN.matcher(url);
        //matcher.group()方法调用之前一定要执行过matcher.matches()方法，不然抛异常：java.lang.IllegalStateException: No match found
        return matcher.matches() && "jdbc:wuzh:".equals(matcher.group("scheme"));
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

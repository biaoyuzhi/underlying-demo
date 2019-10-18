package speedment;


import com.speedment.Manager;
import com.speedment.Speedment;
import speedmentpojo.localhost.LocalhostApplication;
import speedmentpojo.localhost.db0.web1.person.Person;
import speedmentpojo.localhost.db0.web1.user.User;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by wuzh on 2019/10/17.
 * Describe：Speedment框架(基于Java8 Stream的ORM工具包和运行时环境)测试类
 * 1、pom.xml中增加speedment-maven-plugin插件
 * 2、speedment:gui连接数据库
 * 3、在gui界面中自动生成groovy包和com.company.speedment.test.web1等package
 * 4、speedment:generate可以修改上面的groovy包中的文件(enabled = false时，该表的相应java代码不会自动生成)，自动生成自定义的package
 * <p>
 * Stream 与 SQL 有相似的语义，见下表：
 * SQL	        Java8 Stream
 * FROM	        stream()
 * SELECT	    map()
 * WHERE	    filter() (before collecting)
 * HAVING	    filter() (after collecting)
 * JOIN	        flatMap()
 * DISTINCT	    distinct()
 * UNION	    concat(s0, s1).distinct()
 * ORDER BY	    sorted()
 * OFFSET	    skip()
 * LIMIT	    limit()
 * GROUP BY	    collect(groupingBy())
 * COUNT	    count()
 */
public class SpeedmentTest {
    public static void main(String[] args) {
        //需提供连接数据库的密码
        Speedment build = new LocalhostApplication().withPassword("root").build();
        Manager<Person> personManager = build.managerOf(Person.class);
        //打印所有数据行
        personManager.stream()
                      .parallel()         //可以做并行运算
                      .forEach(x-> System.out.println(x));
        System.out.println("#######################################################");
        //获取指定的部分字段(如果不加.orElse，返回的将全是Optional对象)
        personManager.stream().parallel()
                .map(x -> x.getName().orElse("none") + "," + x.getPassword().orElse("none"))
                .forEach(x -> System.out.println(x));
        System.out.println("#######################################################");
        //按某个字段分组
        personManager.stream()
                .collect(Collectors.groupingBy(x->x.getName().orElse("none")))
                .forEach((k,v)-> System.out.printf("%s:\n%s\n",k,v));
        System.out.println("#######################################################");
        //连表查询(这里使用分步骤的单表查询实现，无法同时展示多张表的字段)
        Manager<User> userManager = build.managerOf(User.class);
        Set<String> name = userManager.stream().map(x -> x.getName().orElse("")).collect(Collectors.toSet());
        personManager.stream().filter(Person.NAME.in(name)).forEach(x-> System.out.println(x));
        System.out.println("#######################################################");
        //更新操作
        userManager.stream()
                .filter(x->x.getPassword().equals(Optional.of("333")))  //这里注意是Optional.of，也可以写成：filter(User.PASSWORD.equal("333"))
                .map(x->x.setPassword("123"))
                .forEach(User::update);
        //删除数据
        userManager.stream().filter(User.ID.equal(3)).forEach(User::remove);
        //新增数据
        userManager.newInstance().setId(3).setName("www").setPassword("222").persist();

        //关闭连接
        build.stop();
    }
}

package beanfilter;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import pojo.Man;

/**
 * Created by wuzh on 2019/10/8.
 * Describe：在SpringBoot项目中，下面BeanFilter类可以在bean.xml中的名为wuzh的bean加载完成后再做相应的更新
 *          1、SpringBoot启动类上加注解@ImportResource(locations = "classpath:bean.xml")
 *          2、如果xml文件中只有一个Person类的bean，获取该bean可以使用：
 *                  @Autowired
 *                  private Person per;
 *             如果xml文件中有多个Person类的bean，获取id或name为wuzh的bean可以使用：
 *                  @Resource
 *                  private Person wuzh;
 */
@Component
public class BeanFilter implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //获取id或name为"wuzh"的bean
        BeanDefinition wuzh = beanFactory.getBeanDefinition("wuzh");
        //获取该bean的属性值
        MutablePropertyValues propertyValues = wuzh.getPropertyValues();
        //修改该bean的属性值
        propertyValues.add("name","changedValue");
    }
}

/**
 * Spring通过在初始化时保存ApplicationContext对象的方式来获取xml文件中的bean
 * 参考：https://www.cnblogs.com/yjbjingcha/p/6752265.html
 */
class MainTest{
    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:bean.xml");
        Man wuzh = (Man) ac.getBean("wuzh");
        System.out.println(wuzh.toString());
    }
}

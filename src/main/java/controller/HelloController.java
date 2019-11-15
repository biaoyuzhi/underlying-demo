package controller;

import jmx.HelloAgent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuzh on 2019/11/8.
 * Describe:
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String getHello(){
        System.out.println("HelloController");
        //展示当前缓存中(可通过jmx修改值)hello实例的值
        return HelloAgent.hello.getName();
    }
}

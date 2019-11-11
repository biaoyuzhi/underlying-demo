package controller;

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
        return "hello page!";
    }
}

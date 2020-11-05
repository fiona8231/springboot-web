package com.springboot03.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class LoginController {

    //处理的请求用POST方法
    //@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username")  String username, @RequestParam("password") String password, Map<String, Object> map){

        if(!StringUtils.isEmpty(username) && password.equals("1234")){
                 //防止表单重复提交，重定向

                 //有模板引擎的解析，前面的template，和html都不用加
                 return "redirect:/main.html";
             }else {
                 //登录失败
                 map.put("error", "Username and Password are not correct!");
                 return "index";

             }


    }
}

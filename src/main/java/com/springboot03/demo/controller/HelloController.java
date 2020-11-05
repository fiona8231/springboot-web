package com.springboot03.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    // 查数据，在页面展示
    @RequestMapping("/success")
    public String sucess(Map<String, Object> map){
        map.put("hello", "你好");
        return "success";
    }

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }


}

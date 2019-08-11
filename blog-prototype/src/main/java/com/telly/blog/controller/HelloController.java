package com.telly.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("------hello world------");
        return "hello world!";
    }
}

package com.telly.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器.
 * Create By Telly On 2019/8/9 23:49
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 获取登录界面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录错误
     * @param model
     * @return
     */
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
        return "login";
    }

    /**
     * 返回 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}

package com.telly.blog.controller;

import com.telly.blog.domain.User;
import com.telly.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * User 控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired//自动注入 资源库
    private UserRepository userRepository;

    /**
     *  查询所有用户
     * @param model
     * @return
     */
    // 自动映射类注解，相当于 @RequestMapping("/users")
    @GetMapping
    public ModelAndView list(Model model){
        // 获取用户列表
        model.addAttribute("userList",userRepository.findAll());
        // 设置页面标题
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","uerModel",model);
    }

    /**
     * 根据 id 查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    // 不需要传参，保留 模型 即可
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","usermodel",model);
    }

    /**
     * 新建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user){
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        // 重定向 到 list 页面
        return new ModelAndView("redirect:/users");

    }

    /**
     * 获取修改用户的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}

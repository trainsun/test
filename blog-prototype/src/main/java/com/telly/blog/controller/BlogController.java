package com.telly.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Blog 控制器.
 * Create By Telly On 2019/8/6 19:39
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    /**
     * 返回 博客列表
     * @param order
     * @param keyword
     * @return
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order",required = false,defaultValue = "new") String order,
                            @RequestParam(value = "keyword",required = false) Long keyword){
        System.out.println("order:" + order + ";keyword:" +keyword);
        return "redirect:/index?order="+order+"&keyword="+keyword;
    }
}

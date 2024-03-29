package com.telly.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页控制器.
 * Create By Telly On 2019/8/10 10:30
 */
@Controller
public class UserspaceController {

    /**
     * 点击 用户名称时
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String  username){
        System.out.println("username:" +username);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value="order",required=false,defaultValue="new") String order,
                                   @RequestParam(value="category",required=false ) Long category,
                                   @RequestParam(value="keyword",required=false ) String keyword) {
        if (category != null) {
            System.out.print("category:" +category );
            System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?category="+category);
            return "/userspace/u";

        } else if (keyword != null && keyword.isEmpty() == false) {

            System.out.print("keyword:" +keyword );
            System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?keyword="+keyword);
            return "/userspace/u";
        }
        System.out.print("order:" +order);
        System.out.print("selflink:" + "redirect:/u/"+ username +"/blogs?order="+order);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {

        System.out.print("blogId:" + id);
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {
        return "/userspace/blogedit";
    }

}

package com.longlong.controller;

import com.longlong.entity.Post;
import com.longlong.entity.User;
import com.longlong.service.PostService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @RequestMapping({"/","/index"})
    public String index()
    {
        return "company/index";
    }
    @RequestMapping("/post")
    public String post(Principal principal, Model model)
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        List<Post> postList = postService.queryAllCompanyPost(user.getUserid());
        model.addAttribute("postList",postList);
        return "company/post";
    }
    @RequestMapping("/addpost")
    public String addpost()
    {
        return "company/addpost";
    }
    @RequestMapping("/doaddpost")
    public String doaddpost(
            Principal principal, Model model,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("salary") String salary,
            @RequestParam("requirement") String requirement,
            @RequestParam("introduction") String introduction
    )
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        Post post = new Post();
        post.setCompanyid(user.getUserid());
        post.setName(name);
        post.setType(type);
        post.setSalary(salary);
        post.setRequirement(requirement);
        post.setIntroduction(introduction);
        postService.addPost(post);
        return "redirect:/company/post";
    }
    @GetMapping("/update/{postid}")
    public String update(@PathVariable("postid") Integer postid, Model model)
    {
        List<Post> postList = postService.queryPostById(postid);
        Post post = postList.get(0);
        model.addAttribute("post",post);
        return "company/update";
    }
    @RequestMapping("/doupdate/{postid}")
    public String doupdate(
            @PathVariable("postid") Integer postid,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("salary") String salary,
            @RequestParam("requirement") String requirement,
            @RequestParam("introduction") String introduction
    )
    {
        List<Post> postList = postService.queryPostById(postid);
        Post post = postList.get(0);
        post.setName(name);
        post.setType(type);
        post.setSalary(salary);
        post.setRequirement(requirement);
        post.setIntroduction(introduction);
        postService.updatePost(post);
        return "redirect:/company/post";
    }
}

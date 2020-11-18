package com.longlong.controller;

import com.longlong.entity.User;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login/we")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){

        User user = userService.queryUserByUsername(username);
        if(user==null)
        {
            return "用户名不存在";
        }
        else
        {
            //System.out.println(user.getPassword()+" "+password);
            if(!user.getPassword().equals(password))
                return "密码错误";
            else {
                return "登陆成功";
            }
        }
    }
}

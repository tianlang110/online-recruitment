package com.longlong.controller;

import com.longlong.entity.RegUser;
import com.longlong.entity.User;
import com.longlong.service.RegService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoRegController {

    @Autowired
    private UserService userService;
    @Autowired
    private RegService regService;

    @RequestMapping("/checkusername")
    public String checkusername(String username)
    {
        System.out.println("1111111");
        User user = userService.queryUserByUsername(username);
        if(user != null)
        {
            return "not";
        }
        else
        {
            return "ok";
        }
    }
    @RequestMapping("/doreg")
    public String doReg(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("usertype") int usertype,
                        Model model)
    {
        RegUser user = new RegUser();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setUsertype(usertype);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getUsertype());
        regService.addUser(user);
        return "user/login";
    }
}

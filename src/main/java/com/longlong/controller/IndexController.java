package com.longlong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/index"})
    public String index()
    {
        return "index";
    }
    @RequestMapping("/login")
    public String login()
    {
        return "user/login";
    }
    @RequestMapping("/reg")
    public String reg()
    {
        return "user/reg";
    }

}

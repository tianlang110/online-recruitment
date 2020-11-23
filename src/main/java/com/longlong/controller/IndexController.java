package com.longlong.controller;

import com.longlong.entity.Company;
import com.longlong.entity.Seeker;
import com.longlong.entity.User;
import com.longlong.service.CompanyService;
import com.longlong.service.SeekerService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeekerService seekerService;
    @Autowired
    private CompanyService companyService;
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
    @RequestMapping("/information")
    public String information(Principal principal, Model model)
    {
        System.out.println(principal.getName());
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        if(user.getUsertype()==0)
            model.addAttribute("type","admin");
        else if(user.getUsertype()==1)
        {
            model.addAttribute("type","seeker");
            Seeker seeker = seekerService.querySeekerByUserid(user.getUserid());
            if(seeker==null)
            {
                Seeker newseeker = new Seeker();
                newseeker.setUserid(user.getUserid());
                newseeker.setName("未命名");
                seekerService.addSeeker(newseeker);
                seeker = seekerService.querySeekerByUserid(user.getUserid());
            }
            model.addAttribute("seeker",seeker);
        }
        else {
            model.addAttribute("type","company");
            Company company = companyService.queryCompanyByUserid(user.getUserid());
            if(company==null)
            {
                Company newcompany = new Company();
                newcompany.setName("未命名");
                newcompany.setUserid(user.getUserid());
                companyService.addCompany(newcompany);
                company = companyService.queryCompanyByUserid(user.getUserid());
            }
            model.addAttribute("company",company);
        }
        return "user/information";
    }
    @RequestMapping("/seeker/company")
    public String seekercompany(Model model)
    {
        List<Company> companyList = companyService.queryAllCompany();
        model.addAttribute("companys",companyList);
        return "seeker/company";
    }
}

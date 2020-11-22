package com.longlong.controller;

import com.longlong.entity.Company;
import com.longlong.entity.Seeker;
import com.longlong.entity.User;
import com.longlong.mapper.CompanyMapper;
import com.longlong.service.CompanyService;
import com.longlong.service.SeekerService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class InformationController {
    @Autowired
    SeekerService seekerService;
    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;
    @RequestMapping("/updateseeker")
    public String updateseeker(@RequestParam("name") String name,
                               @RequestParam("sex") String sex,
                               @RequestParam("age") int age,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email,
                               @RequestParam("education") String education,
                               @RequestParam("post") String post,
                               @RequestParam("salary") String salary,
                               Principal principal
                               )
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        Seeker seeker = new Seeker();
        seeker.setName(name);
        seeker.setSex(sex);
        seeker.setAge(age);
        seeker.setPhone(phone);
        seeker.setEmail(email);
        seeker.setEducation(education);
        seeker.setPost(post);
        seeker.setSalary(salary);
        seeker.setUserid(user.getUserid());
        seekerService.updateSeeker(seeker);
        return "index";
    }

    @RequestMapping("/updatecompany")
    public String updateseeker(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("introduction") String introduction,
                               Principal principal
    )
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setIntroduction(introduction);
        company.setUserid(user.getUserid());
        companyService.updateCompany(company);
        return "index";
    }
}

package com.longlong.controller;
import com.longlong.entity.*;
import com.longlong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RegService regService;
    @Autowired
    AdminService adminService;
    @Autowired
    JobFairService jobFairService;
    @Autowired
    PartTimeJobService partTimeJobService;
    @Autowired
    SeekerService seekerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    PostService postService;
    @RequestMapping("/index")
    public String index()
    {
        return "admin/index";
    }
    @RequestMapping("/user")
    public String user(Model model)
    {
        List<User> userList = userService.queryAllUser();
        model.addAttribute("userList",userList);
        return "admin/user";
    }
    @RequestMapping("/delete/{userid}")
    public String delete(
            @PathVariable("userid") int userid
    ){
        User user = userService.queryUserByUserid(userid);
        if(user.getUsertype()==0)
        {
            adminService.deleteadmin(userid);
        } else if(user.getUsertype()==1)
        {
            seekerService.deleteSeeker(userid);
        } else
        {
            companyService.deleteCompany(userid);
            postService.deletePostByCompanyid(userid);
        }
        userService.deleteUser(userid);
        return "redirect:/admin/user";
    }
    @RequestMapping("/queryuser")
    public String query(
            @RequestParam("username") String username,
            Model model
    )
    {
        User user = userService.queryUserByUsername(username);
        List<User> userList = new ArrayList<>();
        if(user!=null)
        {
            userList.add(user);
        }
        model.addAttribute("userList",userList);
        return "admin/user";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin/addadmin";
    }
    @RequestMapping("/addadmin")
    public String addadmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name
    ){
        RegUser user = new RegUser();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setUsertype(0);
        regService.addUser(user);
        Admin admin = new Admin();
        User newUser = userService.queryUserByUsername(username);
        admin.setName(name);
        admin.setUserid(newUser.getUserid());
        adminService.insertAdmin(admin);
        return "redirect:/admin/user";
    }
    @RequestMapping("/jobfair")
    public String jobfair(Model model){
        List<JobFair> jobFairList = jobFairService.queryAllJobFair();
        model.addAttribute("jobFairList",jobFairList);
        return "admin/jobfair";
    }
    @RequestMapping("/jobfairadd")
    public String jobfairadd()
    {
        return "/admin/addjobfair";
    }
    @RequestMapping("/addjobfair")
    public String addjobfair(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("introduction") String introduction
    ){
        JobFair jobFair = new JobFair();
        jobFair.setName(name);
        jobFair.setAddress(address);
        jobFair.setIntroduction(introduction);
        jobFairService.addJobFair(jobFair);
        return "redirect:/admin/jobfair";
    }
    @RequestMapping("/deletejobfair/{id}")
    public String deletejobfair(
            @PathVariable("id") int id
    ){
        jobFairService.deletejobfair(id);
        return "redirect:/admin/jobfair";
    }
    @RequestMapping("/parttimejob")
    public String parttimejob(Model model){
        List<PartTimeJob> partTimeJobList = partTimeJobService.queryAllPartTimeJob();
        model.addAttribute("partTimeJobList",partTimeJobList);
        return "admin/parttimejob";
    }
    @RequestMapping("/parttimejobadd")
    public String parttimejobadd(){
        return "admin/addparttimejob";
    }
    @RequestMapping("/addparttimejob")
    public String addparttimejob(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("introduction") String introduction,
            @RequestParam("phone") String phone
    ){
        PartTimeJob partTimeJob = new PartTimeJob();
        partTimeJob.setName(name);
        partTimeJob.setAddress(address);
        partTimeJob.setIntroduction(introduction);
        partTimeJob.setPhone(phone);
        partTimeJobService.addPartTimeJob(partTimeJob);
        return "redirect:/admin/parttimejob";
    }
    @RequestMapping("/deleteparttimejob/{id}")
    public String deleteparttimejob(
            @PathVariable("id") int id
    ){
        partTimeJobService.deletePartTimeJob(id);
        return "redirect:/admin/jobfair";
    }
}

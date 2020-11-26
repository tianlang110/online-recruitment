package com.longlong.controller;

import com.longlong.entity.JobFair;
import com.longlong.service.JobFairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JobFairController {
    @Autowired
    JobFairService jobFairService;
    @RequestMapping("/jobfair")
    public String jobfair(Model model)
    {
        List<JobFair> jobFairList = jobFairService.queryAllJobFair();
        model.addAttribute("jobFairList",jobFairList);
        return "jobfair";
    }
    @RequestMapping("/queryjobfair")
    public String quary(
            @RequestParam("name") String name,
            Model model
    ){
        List<JobFair> jobFairList = jobFairService.queryJobFairByName(name);
        model.addAttribute("jobFairList",jobFairList);
        return "jobfair";
    }
}

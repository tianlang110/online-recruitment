package com.longlong.controller;

import com.longlong.entity.JobFair;
import com.longlong.entity.PartTimeJob;
import com.longlong.service.JobFairService;
import com.longlong.service.PartTimeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PartTimeJobController {
    @Autowired
    PartTimeJobService partTimeJobService;
    @RequestMapping("/parttimejob")
    public String jobfair(Model model)
    {
        List<PartTimeJob> partTimeJobList = partTimeJobService.queryAllPartTimeJob();
        model.addAttribute("partTimeJobList",partTimeJobList);
        return "parttimejob";
    }
    @RequestMapping("/queryparttimejob")
    public String quary(
            @RequestParam("name") String name,
            Model model
    ){
        List<PartTimeJob> partTimeJobList = partTimeJobService.queryPartTimeJobByName(name);
        model.addAttribute("partTimeJobList",partTimeJobList);
        return "parttimejob";
    }
}

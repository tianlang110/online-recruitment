package com.longlong.controller;

import com.longlong.entity.*;
import com.longlong.service.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    SeekerService seekerService;
    @Autowired
    CandidateService candidateService;
    @Autowired
    RecruitService recruitService;
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
    @GetMapping("/delete/{postid}")
    public String delete(@PathVariable("postid") Integer postid)
    {
        postService.delete(postid);
        return "redirect:/company/post";
    }
    @RequestMapping("/query")
    public String query(Principal principal,@RequestParam("name") String name, Model model)
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        List<Post> postList = postService.queryPostByNameAndCompanyId(name,user.getUserid());
        model.addAttribute("postList",postList);
        return "company/post";
    }
    @RequestMapping("/seeker")
    public String seeker(Model model){
        List<Seeker> seekerList =seekerService.queryAllSeeker();
        model.addAttribute("seekerList",seekerList);
        return "company/seeker";
    }
    @RequestMapping("/details/{userid}")
    public String details(
            @PathVariable("userid") int userid,
            Model model
    ){
        Seeker seeker = seekerService.querySeekerByUserid(userid);
        model.addAttribute("seeker",seeker);
        return "company/details";
    }
    @RequestMapping("/candidate")
    public String candidate(Principal principal,Model model){
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        List<Candidate> candidateList = candidateService.queryCandidateByCompanyid(user.getUserid());
        List<BigCandidate> bigCandidateList = new ArrayList<>();
        for(int i=0;i<candidateList.size();i++)
        {
            Candidate candidate = candidateList.get(i);
            BigCandidate bigCandidate = new BigCandidate();
            Seeker seeker = seekerService.querySeekerByUserid(candidate.getSeekerid());
            Post post = postService.queryPostById(candidate.getPostid()).get(0);
            bigCandidate.setPostname(post.getName());
            bigCandidate.setSeekername(seeker.getName());
            bigCandidate.setType(candidate.getState());
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
            String str = sdf.format(candidate.getTime());
            bigCandidate.setTime(str);
            bigCandidate.setId(candidate.getId());
            bigCandidate.setSeekerid(candidate.getSeekerid());
            bigCandidateList.add(bigCandidate);
        }
        model.addAttribute("candidateList",bigCandidateList);
        return "company/candidate";
    }
    @RequestMapping("/agree/{id}")
    public String agree(
            @PathVariable("id") int id
    ){
        Candidate candidate = candidateService.queryCandidateById(id);
        candidate.setState("已同意");
        candidateService.updateCandidate(candidate);
        return "redirect:/company/candidate";
    }
    @RequestMapping("/refuse/{id}")
    public String refuse(
            @PathVariable("id") int id
    ){
        Candidate candidate = candidateService.queryCandidateById(id);
        candidate.setState("已拒绝");
        candidateService.updateCandidate(candidate);
        return "redirect:/company/candidate";
    }
    @RequestMapping("/recruit")
    public String allrecruit(
            Principal principal,Model model
    ){
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        List<Recruit> recruitList = recruitService.queryRecruitByCompanyid(user.getUserid());
        List<BigRecruit> bigRecruitList = new ArrayList<>();
        for(int i=0;i<recruitList.size();i++)
        {
            Recruit recruit = recruitList.get(i);
            BigRecruit bigRecruit = new BigRecruit();
            Seeker seeker = seekerService.querySeekerByUserid(recruit.getSeekerid());
            bigRecruit.setSeekername(seeker.getName());
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
            String str = sdf.format(recruit.getTime());
            bigRecruit.setTime(str);
            bigRecruit.setType(recruit.getState());
            bigRecruitList.add(bigRecruit);
        }
        model.addAttribute("recruitList",bigRecruitList);
        return "company/recruit";
    }
    @RequestMapping("/recruit/{seekerid}")
    public String recruit(
            @PathVariable("seekerid") int seekerid,
            Principal principal
    )
    {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        Recruit recruit = new Recruit();
        recruit.setCompanyid(user.getUserid());
        recruit.setSeekerid(seekerid);
        recruit.setState("待回复");
        recruit.setTime(new Date());
        recruitService.addRecruit(recruit);
        return "redirect:/company/recruit";
    }
}

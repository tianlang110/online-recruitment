package com.longlong.controller;

import com.longlong.entity.*;
import com.longlong.service.CandidateService;
import com.longlong.service.CompanyService;
import com.longlong.service.PostService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.swing.BakedArrayList;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seeker")
public class SeekerController {
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @Autowired
    CompanyService companyService;
    @Autowired
    PostService postService;
    @Autowired
    CandidateService candidateService;
    @Autowired
    UserService userService;
    @RequestMapping("/querycompany")
    public String querycompany(@RequestParam("name") String name , Model model)
    {
        List<Company> companyList = companyService.queryCompanyByName(name);
        model.addAttribute("companys",companyList);
        return "seeker/company";
    }
    @RequestMapping("/post")
    public String post(Model model){
        List<Post> postList = postService.queryAllPost();
        model.addAttribute("postList",postList);
        return "seeker/post";
    }
    @RequestMapping("/details/{postid}")
    public String details(@PathVariable("postid") int postid,Model model){
        List<Post> postList =postService.queryPostById(postid);
        Post post = postList.get(0);
        Company company = companyService.queryCompanyByUserid(post.getCompanyid());
        model.addAttribute("post",post);
        model.addAttribute("company",company);
        return "seeker/postdetails";
    }
    @RequestMapping("/allcandidate")
    public String allcandidate(Principal principal,Model model){
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        List<Candidate> candidateList = candidateService.queryCandidateBySeekerid(user.getUserid());
        List<BigCandidate> bigCandidateList = new ArrayList<>();
        for(int i=0;i<candidateList.size();i++)
        {
            List<Post> postList =  postService.queryPostById(candidateList.get(i).getPostid());
            Post post = postList.get(0);
            BigCandidate bigCandidate = new BigCandidate();
            bigCandidate.setPostname(post.getName());
            bigCandidate.setPosttype(post.getType());
            bigCandidate.setTime(candidateList.get(i).getTime().toString());
            bigCandidate.setType(candidateList.get(i).getState());
            bigCandidateList.add(bigCandidate);
        }
        model.addAttribute("candidateList",bigCandidateList);
        return "seeker/candidate";
    }
    @RequestMapping("/candidate/{postid}")
    public String candidate(@PathVariable("postid") int postid,Principal principal,Model model){
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        Candidate candidate = new Candidate();
        candidate.setPostid(postid);
        candidate.setSeekerid(user.getUserid());
        candidate.setTime(new Date());
        candidate.setState("已投递");
        candidateService.addCandidate(candidate);
        return "redirect:/seeker/allcandidate";
    }
}

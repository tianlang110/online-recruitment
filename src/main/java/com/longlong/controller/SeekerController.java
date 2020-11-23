package com.longlong.controller;

import com.longlong.entity.Company;
import com.longlong.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/querycompany")
    public String querycompany(@RequestParam("name") String name , Model model)
    {
        List<Company> companyList = companyService.queryCompanyByName(name);
        model.addAttribute("companys",companyList);
        return "seeker/company";
    }
}

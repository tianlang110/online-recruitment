package com.longlong.service;

import com.longlong.entity.Company;
import com.longlong.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyMapper companyMapper;
    public Company queryCompanyByUserid(int userid)
    {
        return companyMapper.queryCompanyByUserid(userid);
    }
    public int addCompany(Company company)
    {
        return companyMapper.addCompany(company);
    }
    public int updateCompany(Company company)
    {
        return companyMapper.updateCompany(company);
    }
    public List<Company> queryAllCompany()
    {
        return companyMapper.queryAllCompany();
    }
    public List<Company> queryCompanyByName(String name)
    {
        return companyMapper.queryCompanyByName(name);
    }
}

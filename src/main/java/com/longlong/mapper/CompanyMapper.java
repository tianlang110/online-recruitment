package com.longlong.mapper;

import com.longlong.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    Company queryCompanyByUserid(int userid);
    List<Company> queryAllCompany();
    List<Company> queryCompanyByName(String name);
    int addCompany(Company company);
    int updateCompany(Company company);
}

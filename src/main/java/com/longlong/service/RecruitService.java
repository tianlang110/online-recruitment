package com.longlong.service;

import com.longlong.entity.Recruit;
import com.longlong.mapper.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {
    @Autowired
    RecruitMapper recruitMapper;
    public List<Recruit> queryRecruitById(int id) {
        return recruitMapper.queryRecruitById(id);
    }
    public List<Recruit> queryRecruitByCompanyid(int companyid) {
        return recruitMapper.queryRecruitByCompanyid(companyid);
    }
    public List<Recruit> queryRecruitBySeekerid(int seekerid) {
        return recruitMapper.queryRecruitBySeekerid(seekerid);
    }
    public List<Recruit> queryAllRecruit() {
        return recruitMapper.queryAllRecruit();
    }
    public int addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }
    public int updateRecruit(Recruit recruit) {
        return recruitMapper.updateRecruit(recruit);
    }
    public int deleteRecruit(int id) {
        return recruitMapper.deleteRecruit(id);
    }
}

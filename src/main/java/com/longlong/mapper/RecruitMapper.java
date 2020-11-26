package com.longlong.mapper;

import com.longlong.entity.Recruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecruitMapper {
    List<Recruit> queryRecruitById(int id);
    List<Recruit> queryRecruitByCompanyid(int companyid);
    List<Recruit> queryRecruitBySeekerid(int seekerid);
    List<Recruit> queryAllRecruit();
    int addRecruit(Recruit recruit);
    int updateRecruit(Recruit recruit);
    int deleteRecruit(int id);
}

package com.longlong.mapper;

import com.longlong.entity.JobFair;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JobFairMapper {
    List<JobFair> queryJobFairById(int id);
    List<JobFair> queryJobFairByName(String name);
    List<JobFair> queryAllJobFair();
    int addJobFair(JobFair jobfair);
    int updateJobFair(JobFair jobfair);
    int deletejobfair(int id);
}

package com.longlong.service;

import com.longlong.entity.JobFair;
import com.longlong.mapper.JobFairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobFairService {
    @Autowired
    JobFairMapper jobFairMapper;
    public List<JobFair> queryJobFairById(int id) {
        return jobFairMapper.queryJobFairById(id);
    }
    public List<JobFair> queryJobFairByName(String name) {
        return jobFairMapper.queryJobFairByName(name);
    }
    public List<JobFair> queryAllJobFair() {
        return jobFairMapper.queryAllJobFair();
    }
    public int addJobFair(JobFair jobFair) {
        return jobFairMapper.addJobFair(jobFair);
    }
    public int updateJobFair(JobFair jobFair) {
        return jobFairMapper.updateJobFair(jobFair);
    }
    public int deletejobfair(int id){
        return jobFairMapper.deletejobfair(id);
    }
}

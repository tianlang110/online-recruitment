package com.longlong.service;

import com.longlong.entity.PartTimeJob;
import com.longlong.mapper.PartTimeJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartTimeJobService {
    @Autowired
    PartTimeJobMapper partTimeJobMapper;
    public List<PartTimeJob> queryPartTimeJobById(int id) {
        return partTimeJobMapper.queryPartTimeJobById(id);
    }
    public List<PartTimeJob> queryPartTimeJobByName(String name) {
        return partTimeJobMapper.queryPartTimeJobByName(name);
    }
    public List<PartTimeJob> queryAllPartTimeJob() {
        return partTimeJobMapper.queryAllPartTimeJob();
    }
    public int addPartTimeJob(PartTimeJob partTimeJob) {
        return partTimeJobMapper.addPartTimeJob(partTimeJob);
    }
    public int updatePartTimeJob(PartTimeJob partTimeJob) {
        return partTimeJobMapper.updatePartTimeJob(partTimeJob);
    }
    public int deletePartTimeJob(int id){
        return partTimeJobMapper.deletePartTimeJob(id);
    }
}

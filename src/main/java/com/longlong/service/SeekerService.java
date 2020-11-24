package com.longlong.service;

import com.longlong.entity.Seeker;
import com.longlong.mapper.SeekerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeekerService {
    @Autowired
    SeekerMapper seekerMapper;
    public Seeker querySeekerByUserid(int userid)
    {
        return seekerMapper.querySeekerByUserid(userid);
    }
    public int addSeeker(Seeker seeker)
    {
        return seekerMapper.addSeeker(seeker);
    }
    public int updateSeeker(Seeker seeker)
    {
        return seekerMapper.updateSeeker(seeker);
    }
    public List<Seeker> queryAllSeeker()
    {
        return seekerMapper.queryAllSeeker();
    }
}

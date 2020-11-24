package com.longlong.service;

import com.longlong.entity.Candidate;
import com.longlong.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateMapper candidateMapper;
    public List<Candidate> queryCandidateBySeekerid(int seekerid){
        return candidateMapper.queryCandidateBySeekerid(seekerid);
    }
    public List<Candidate> queryCandidateByPostid(int postid){
        return candidateMapper.queryCandidateByPostid(postid);
    }
    public List<Candidate> queryCandidateByCompanyid(int companyid){
        return candidateMapper.queryCandidateByCompanyid(companyid);
    }
    public List<Candidate> queryAllCandidate(){
        return candidateMapper.queryAllCandidate();
    }
    public int addCandidate(Candidate candidate){
        return candidateMapper.addCandidate(candidate);
    }
    public int updateCandidate(Candidate candidate){
        return candidateMapper.updateCandidate(candidate);
    }
}

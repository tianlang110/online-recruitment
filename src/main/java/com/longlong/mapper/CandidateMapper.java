package com.longlong.mapper;

import com.longlong.entity.Candidate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CandidateMapper {
    List<Candidate> queryCandidateBySeekerid(int seekerid);
    List<Candidate> queryCandidateByPostid(int postid);
    List<Candidate> queryCandidateByCompanyid(int companyid);
    List<Candidate> queryAllCandidate();
    Candidate queryCandidateById(int id);
    int addCandidate(Candidate candidate);
    int updateCandidate(Candidate candidate);
}

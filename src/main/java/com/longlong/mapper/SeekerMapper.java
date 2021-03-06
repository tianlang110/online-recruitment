package com.longlong.mapper;

import com.longlong.entity.Seeker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SeekerMapper {
    Seeker querySeekerByUserid(int userid);
    int addSeeker(Seeker seeker);
    int updateSeeker(Seeker seeker);
    List<Seeker> queryAllSeeker();
    int deleteSeeker(int userid);
}


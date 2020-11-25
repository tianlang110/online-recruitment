package com.longlong.mapper;

import com.longlong.entity.PartTimeJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PartTimeJobMapper {
    List<PartTimeJob> queryPartTimeJobById(int id);
    List<PartTimeJob> queryPartTimeJobByName(String name);
    List<PartTimeJob> queryAllPartTimeJob();
    int addPartTimeJob(PartTimeJob partTimeJob);
    int updatePartTimeJob(PartTimeJob partTimeJob);
    int deletePartTimeJob(int id);
}

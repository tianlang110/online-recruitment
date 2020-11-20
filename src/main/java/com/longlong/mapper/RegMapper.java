package com.longlong.mapper;

import com.longlong.entity.RegUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegMapper {
    int addUser(RegUser user);
}

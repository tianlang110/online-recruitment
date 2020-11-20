package com.longlong.mapper;

import com.longlong.entity.RegUser;
import com.longlong.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User queryUserByUsername(String username);
    int addUser(RegUser user);
}

package com.longlong.mapper;

import com.longlong.entity.RegUser;
import com.longlong.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User queryUserByUsername(String username);
    int addUser(RegUser user);
    List<User> queryAllUser();
    int deleteUser(int userid);
    User queryUserByUserid(int userid);
}

package com.longlong.service;

import com.longlong.entity.RegUser;
import com.longlong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    @Autowired
    UserMapper userMapper;

    public int addUser(RegUser user) {
        //System.out.println(user.getUsername());
        return userMapper.addUser(user);
    }

}

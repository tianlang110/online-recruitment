package com.longlong.service;

import com.longlong.entity.Admin;
import com.longlong.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;
    public List<Admin> queryAdminByUserid(int userid) {
        return adminMapper.queryAdminByUserid(userid);
    }
    public List<Admin> queryAdminByName(String name) {
        return adminMapper.queryAdminByName(name);
    }
    public List<Admin> queryAllAdmin() {
        return adminMapper.queryAllAdmin();
    }
    public int insertAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }
    public int deleteadmin(int userid){
        return adminMapper.deleteadmin(userid);
    }
}

package com.longlong.mapper;

import com.longlong.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    List<Admin> queryAdminByUserid(int userid);
    List<Admin> queryAdminByName(String name);
    List<Admin> queryAllAdmin();
    int addAdmin(Admin admin);
    int updateAdmin(Admin admin);
    int deleteadmin(int userid);
}

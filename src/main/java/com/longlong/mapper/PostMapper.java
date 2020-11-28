package com.longlong.mapper;

import com.longlong.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {
    List<Post> queryPostByName(String name);
    List<Post> queryPostById(int postid);
    List<Post> queryPostByNameAndCompanyId(String name, int companyid);
    List<Post> queryAllPost();
    List<Post> queryAllCompanyPost(int companyid);
    int addPost(Post post);
    int updatePost(Post post);
    int deletePost(int postid);
    int deletePostByCompanyid(int company);
}

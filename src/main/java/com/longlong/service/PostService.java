package com.longlong.service;

import com.longlong.entity.Post;
import com.longlong.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;
    public List<Post> queryAllCompanyPost(int companyid){
        return postMapper.queryAllCompanyPost(companyid);
    }
    public List<Post> queryAllPost(){
        return postMapper.queryAllPost();
    }
    public int addPost(Post post)
    {
        return postMapper.addPost(post);
    }
    public List<Post> queryPostById(int postid){
        return postMapper.queryPostById(postid);
    }
    public int updatePost(Post post){
        return postMapper.updatePost(post);
    }
}

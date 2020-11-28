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
    public int delete(int postid){
        return postMapper.deletePost(postid);
    }
    public List<Post> queryPostByNameAndCompanyId(String name,int companyid)
    {
        return postMapper.queryPostByNameAndCompanyId(name,companyid);
    }
    public int deletePostByCompanyid(int companyid){
        return postMapper.deletePostByCompanyid(companyid);
    }
}

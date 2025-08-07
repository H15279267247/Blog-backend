package com.zhieasy.blog.Service.impl;

import com.zhieasy.blog.Service.BlogLikeService;
import com.zhieasy.blog.Mapper.BlogLikeMapper;
import com.zhieasy.blog.entity.BlogLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogLikeServiceImpl implements BlogLikeService {
    @Autowired
    private BlogLikeMapper blogLikeMapper;

    @Override
    public boolean likeBlog(Integer blogId, Integer userId) {
        // 检查是否已经点赞
        BlogLike existing = blogLikeMapper.selectByBlogIdAndUserId(blogId, userId);
        if (existing != null) {
            return false; // 已经点赞过了
        }

        BlogLike blogLike = new BlogLike();
        blogLike.setBlogId(blogId);
        blogLike.setUserId(userId);
        return blogLikeMapper.insert(blogLike) > 0;
    }

    @Override
    public boolean unlikeBlog(Integer blogId, Integer userId) {
        return blogLikeMapper.deleteByBlogIdAndUserId(blogId, userId) > 0;
    }

    @Override
    public int getLikeCount(Integer blogId) {
        return blogLikeMapper.countByBlogId(blogId);
    }

    @Override
    public boolean isLiked(Integer blogId, Integer userId) {
        return blogLikeMapper.selectByBlogIdAndUserId(blogId, userId) != null;
    }
}
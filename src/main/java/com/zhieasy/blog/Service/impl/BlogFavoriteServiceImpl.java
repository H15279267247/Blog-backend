package com.zhieasy.blog.Service.impl;

import com.zhieasy.blog.Service.BlogFavoriteService;
import com.zhieasy.blog.Mapper.BlogFavoriteMapper;
import com.zhieasy.blog.entity.BlogFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogFavoriteServiceImpl implements BlogFavoriteService {
    @Autowired
    private BlogFavoriteMapper blogFavoriteMapper;

    @Override
    public boolean favoriteBlog(Integer blogId, Integer userId) {
        BlogFavorite existing = blogFavoriteMapper.selectByBlogIdAndUserId(blogId, userId);
        if (existing != null) {
            return false; // 已经收藏过了
        }
        BlogFavorite blogFavorite = new BlogFavorite();
        blogFavorite.setBlogId(blogId);
        blogFavorite.setUserId(userId);
        return blogFavoriteMapper.insert(blogFavorite) > 0;
    }

    @Override
    public boolean unfavoriteBlog(Integer blogId, Integer userId) {
        return blogFavoriteMapper.deleteByBlogIdAndUserId(blogId, userId) > 0;
    }

    @Override
    public List<BlogFavorite> getFavoritesByUserId(Integer userId) {
        return blogFavoriteMapper.selectByUserId(userId);
    }

    @Override
    public boolean isFavorited(Integer blogId, Integer userId) {
        return blogFavoriteMapper.selectByBlogIdAndUserId(blogId, userId) != null;
    }
}
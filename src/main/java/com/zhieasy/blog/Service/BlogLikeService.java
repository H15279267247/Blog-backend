package com.zhieasy.blog.Service;

import com.zhieasy.blog.entity.BlogLike;

public interface BlogLikeService {
    boolean likeBlog(Integer blogId, Integer userId);
    boolean unlikeBlog(Integer blogId, Integer userId);
    int getLikeCount(Integer blogId);
    boolean isLiked(Integer blogId, Integer userId);
}
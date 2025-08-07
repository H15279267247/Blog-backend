package com.zhieasy.blog.Service;

import com.zhieasy.blog.entity.BlogFavorite;
import java.util.List;

public interface BlogFavoriteService {
    boolean favoriteBlog(Integer blogId, Integer userId);
    boolean unfavoriteBlog(Integer blogId, Integer userId);
    List<BlogFavorite> getFavoritesByUserId(Integer userId);
    boolean isFavorited(Integer blogId, Integer userId);
}

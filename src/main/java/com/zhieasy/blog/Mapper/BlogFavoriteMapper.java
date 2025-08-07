package com.zhieasy.blog.Mapper;

import com.zhieasy.blog.entity.BlogFavorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BlogFavoriteMapper {
    int insert(BlogFavorite blogFavorite);
    int deleteByBlogIdAndUserId(@Param("blogId") Integer blogId, @Param("userId") Integer userId);
    BlogFavorite selectByBlogIdAndUserId(@Param("blogId") Integer blogId, @Param("userId") Integer userId);
    List<BlogFavorite> selectByUserId(@Param("userId") Integer userId);
}
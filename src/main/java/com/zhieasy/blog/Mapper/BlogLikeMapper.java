package com.zhieasy.blog.Mapper;

import com.zhieasy.blog.entity.BlogLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BlogLikeMapper {
    int insert(BlogLike blogLike);
    int deleteByBlogIdAndUserId(@Param("blogId") Integer blogId, @Param("userId") Integer userId);
    BlogLike selectByBlogIdAndUserId(@Param("blogId") Integer blogId, @Param("userId") Integer userId);
    int countByBlogId(@Param("blogId") Integer blogId);
    List<BlogLike> selectByUserId(@Param("userId") Integer userId);
}
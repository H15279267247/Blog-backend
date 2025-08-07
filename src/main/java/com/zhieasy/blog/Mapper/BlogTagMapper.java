package com.zhieasy.blog.Mapper;

import com.zhieasy.blog.entity.BlogTag;
import com.zhieasy.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BlogTagMapper {
    int insert(BlogTag blogTag);
    int deleteByBlogId(@Param("blogId") Integer blogId);
    int deleteByBlogIdAndTagId(@Param("blogId") Integer blogId, @Param("tagId") Integer tagId);
    List<Tag> selectTagsByBlogId(@Param("blogId") Integer blogId);
    List<BlogTag> selectByBlogId(@Param("blogId") Integer blogId);
}
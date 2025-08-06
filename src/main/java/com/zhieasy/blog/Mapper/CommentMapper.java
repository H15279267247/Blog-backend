package com.zhieasy.blog.Mapper;

import com.zhieasy.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper {
    int insert(Comment comment);
    int deleteById(@Param("id") Integer id);
    Comment selectById(@Param("id") Integer id);
    List<Comment> selectByBlogId(@Param("blogId") Integer blogId);
    List<Comment> selectByParentId(@Param("parentId") Integer parentId);
    List<Comment> selectByBlogIdAndParentId(@Param("blogId") Integer blogId, @Param("parentId") Integer parentId);
    List<Comment> selectByUserId(@Param("userId") Integer userId);
}
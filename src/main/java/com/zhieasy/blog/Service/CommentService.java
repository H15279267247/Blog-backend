package com.zhieasy.blog.Service;

import com.zhieasy.blog.entity.Comment;
import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    boolean deleteComment(Integer commentId, Integer userId, boolean isAdminOrAuthor);
    List<Comment> getCommentsByBlogId(Integer blogId);
    List<Comment> getCommentTreeByBlogId(Integer blogId);
}
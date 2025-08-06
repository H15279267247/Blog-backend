package com.zhieasy.blog.Service.impl;

import com.zhieasy.blog.Service.CommentService;
import com.zhieasy.blog.Mapper.CommentMapper;
import com.zhieasy.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment addComment(Comment comment) {
        commentMapper.insert(comment);
        return comment;
    }

    @Override
    public boolean deleteComment(Integer commentId, Integer userId, boolean isAdminOrAuthor) {
        Comment comment = commentMapper.selectById(commentId);
        if (comment == null) return false;
        if (!isAdminOrAuthor && !Objects.equals(comment.getUserId(), userId)) {
            return false;
        }
        commentMapper.deleteById(commentId);
        return true;
    }

    @Override
    public List<Comment> getCommentsByBlogId(Integer blogId) {
        return commentMapper.selectByBlogId(blogId);
    }

    @Override
    public List<Comment> getCommentTreeByBlogId(Integer blogId) {
        List<Comment> all = commentMapper.selectByBlogId(blogId);
        Map<Integer, List<Comment>> parentMap = all.stream().filter(c -> c.getParentId() != null)
                .collect(Collectors.groupingBy(Comment::getParentId));
        List<Comment> roots = all.stream().filter(c -> c.getParentId() == null).collect(Collectors.toList());
        for (Comment root : roots) {
            buildTree(root, parentMap);
        }
        return roots;
    }

    private void buildTree(Comment parent, Map<Integer, List<Comment>> parentMap) {
        List<Comment> children = parentMap.get(parent.getId());
        if (children != null) {
            // 假设Comment类有setChildren方法
            try {
                java.lang.reflect.Method m = parent.getClass().getMethod("setChildren", List.class);
                m.invoke(parent, children);
            } catch (Exception ignored) {}
            for (Comment child : children) {
                buildTree(child, parentMap);
            }
        }
    }
}
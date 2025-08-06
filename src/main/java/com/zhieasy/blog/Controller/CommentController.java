package com.zhieasy.blog.Controller;

import com.zhieasy.blog.Service.CommentService;
import com.zhieasy.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 添加评论
    @PostMapping
    public Map<String, Object> addComment(@RequestBody Comment comment) {
        Comment saved = commentService.addComment(comment);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", saved);
        resp.put("message", "评论发布成功");
        return resp;
    }

    // 获取评论树
    @GetMapping("/tree")
    public Map<String, Object> getCommentTree(@RequestParam Integer blogId) {
        List<Comment> tree = commentService.getCommentTreeByBlogId(blogId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", tree);
        resp.put("message", "获取评论树成功");
        return resp;
    }

    // 删除评论
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteComment(@PathVariable Integer id, @RequestParam Integer userId, @RequestParam(defaultValue = "false") boolean isAdminOrAuthor) {
        boolean ok = commentService.deleteComment(id, userId, isAdminOrAuthor);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", ok ? 200 : 403);
        resp.put("data", null);
        resp.put("message", ok ? "评论及其子评论删除成功" : "无权限删除该评论");
        return resp;
    }
}
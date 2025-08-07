package com.zhieasy.blog.Controller;

import com.zhieasy.blog.Service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/likes")
public class BlogLikeController {
    @Autowired
    private BlogLikeService blogLikeService;

    // 点赞博客
    @PostMapping
    public Map<String, Object> likeBlog(@RequestBody Map<String, Object> request) {
        Integer blogId = (Integer) request.get("blogId");
        Integer userId = (Integer) request.get("userId"); // 实际应该从JWT中获取

        boolean success = blogLikeService.likeBlog(blogId, userId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", null);
        resp.put("message", success ? "点赞成功" : "已经点赞过了");
        return resp;
    }

    // 取消点赞
    @DeleteMapping
    public Map<String, Object> unlikeBlog(@RequestParam Integer blogId, @RequestParam Integer userId) {
        boolean success = blogLikeService.unlikeBlog(blogId, userId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", null);
        resp.put("message", "取消点赞成功");
        return resp;
    }

    // 获取博客点赞人数
    @GetMapping("/count")
    public Map<String, Object> getLikeCount(@RequestParam Integer blogId) {
        int count = blogLikeService.getLikeCount(blogId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", count);
        resp.put("message", "获取点赞数成功");
        return resp;
    }
}
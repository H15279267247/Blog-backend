package com.zhieasy.blog.Controller;

import com.zhieasy.blog.Service.BlogFavoriteService;
import com.zhieasy.blog.entity.BlogFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/favorites")
public class BlogFavoriteController {
    @Autowired
    private BlogFavoriteService blogFavoriteService;

    // 收藏博客
    @PostMapping
    public Map<String, Object> favoriteBlog(@RequestBody Map<String, Object> request) {
        Integer blogId = (Integer) request.get("blogId");
        Integer userId = (Integer) request.get("userId"); // 实际应从JWT获取
        boolean success = blogFavoriteService.favoriteBlog(blogId, userId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", null);
        resp.put("message", success ? "收藏成功" : "已经收藏过了");
        return resp;
    }

    // 取消收藏
    @DeleteMapping
    public Map<String, Object> unfavoriteBlog(@RequestParam Integer blogId, @RequestParam Integer userId) {
        boolean success = blogFavoriteService.unfavoriteBlog(blogId, userId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", null);
        resp.put("message", "取消收藏成功");
        return resp;
    }

    // 获取用户收藏列表
    @GetMapping("/my")
    public Map<String, Object> getMyFavorites(@RequestParam Integer userId) {
        List<BlogFavorite> list = blogFavoriteService.getFavoritesByUserId(userId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", list);
        resp.put("message", "获取收藏成功");
        return resp;
    }
}
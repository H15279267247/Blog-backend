package com.zhieasy.blog.Controller;

import com.zhieasy.blog.Service.TagService;
import com.zhieasy.blog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    // 查询所有标签
    @GetMapping
    public Map<String, Object> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", tags);
        resp.put("message", "查询成功");
        return resp;
    }

    // 博客绑定标签
    @PostMapping("/{blogId}/tags")
    public Map<String, Object> bindTagsToBlog(@PathVariable Integer blogId, @RequestBody Map<String, Object> request) {
        @SuppressWarnings("unchecked")
        List<Integer> tagIds = (List<Integer>) request.get("tagIds");
        boolean success = tagService.bindTagsToBlog(blogId, tagIds);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", null);
        resp.put("message", "标签绑定成功");
        return resp;
    }

    // 查询某博客的标签
    @GetMapping("/{blogId}/tags")
    public Map<String, Object> getTagsByBlogId(@PathVariable Integer blogId) {
        List<Tag> tags = tagService.getTagsByBlogId(blogId);
        Map<String, Object> resp = new HashMap<>();
        resp.put("code", 200);
        resp.put("data", tags);
        resp.put("message", "获取成功");
        return resp;
    }
}
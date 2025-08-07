package com.zhieasy.blog.Service;

import com.zhieasy.blog.entity.Tag;
import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
    Tag getTagById(Integer id);
    Tag getTagByName(String name);
    boolean addTag(Tag tag);
    boolean updateTag(Tag tag);
    boolean deleteTag(Integer id);
    boolean bindTagsToBlog(Integer blogId, List<Integer> tagIds);
    List<Tag> getTagsByBlogId(Integer blogId);
}
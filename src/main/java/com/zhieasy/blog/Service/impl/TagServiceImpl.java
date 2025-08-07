package com.zhieasy.blog.Service.impl;

import com.zhieasy.blog.Service.TagService;
import com.zhieasy.blog.Mapper.BlogTagMapper;
import com.zhieasy.blog.Mapper.TagMapper;
import com.zhieasy.blog.entity.Tag;
import com.zhieasy.blog.entity.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.selectAll();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.selectById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.selectByName(name);
    }

    @Override
    public boolean addTag(Tag tag) {
        return tagMapper.insert(tag) > 0;
    }

    @Override
    public boolean updateTag(Tag tag) {
        return tagMapper.update(tag) > 0;
    }

    @Override
    public boolean deleteTag(Integer id) {
        return tagMapper.deleteById(id) > 0;
    }

    @Override
    @Transactional
    public boolean bindTagsToBlog(Integer blogId, List<Integer> tagIds) {
        // 先删除该博客的所有标签关联
        blogTagMapper.deleteByBlogId(blogId);

        // 重新绑定新的标签
        if (tagIds != null && !tagIds.isEmpty()) {
            for (Integer tagId : tagIds) {
                BlogTag blogTag = new BlogTag();
                blogTag.setBlogId(blogId);
                blogTag.setTagId(tagId);
                blogTagMapper.insert(blogTag);
            }
        }
        return true;
    }

    @Override
    public List<Tag> getTagsByBlogId(Integer blogId) {
        return blogTagMapper.selectTagsByBlogId(blogId);
    }
}
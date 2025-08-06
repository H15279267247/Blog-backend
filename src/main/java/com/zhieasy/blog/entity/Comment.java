package com.zhieasy.blog.entity;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer id;
    private Integer blogId;
    private Integer userId;
    private Integer parentId;
    private String content;
    private Date createTime;
    private List<Comment> children;

    // getter 和 setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getBlogId() { return blogId; }
    public void setBlogId(Integer blogId) { this.blogId = blogId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getParentId() { return parentId; }
    public void setParentId(Integer parentId) { this.parentId = parentId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public List<Comment> getChildren() { return children; }
    public void setChildren(List<Comment> children) { this.children = children; }
}
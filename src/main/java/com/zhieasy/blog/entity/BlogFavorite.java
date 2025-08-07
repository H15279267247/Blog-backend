package com.zhieasy.blog.entity;

import java.util.Date;

public class BlogFavorite {
    private Integer id;
    private Integer blogId;
    private Integer userId;
    private Date createTime;

    // getter 和 setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getBlogId() { return blogId; }
    public void setBlogId(Integer blogId) { this.blogId = blogId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
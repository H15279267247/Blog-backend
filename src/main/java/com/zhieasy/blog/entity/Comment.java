package com.zhieasy.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private Integer id;
    private Integer blogId;
    private Integer userId;
    private Integer parentId;
    private String content;
    private Date createTime;
    private List<Comment> children;
}
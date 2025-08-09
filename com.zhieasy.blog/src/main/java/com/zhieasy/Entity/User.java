package com.zhieasy.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        private Integer id;
        private String phone;
        private String password;
        private String nickname;
        private String avatar;
        private Integer gender;
        private LocalDate birthday;
        private String location;
        private String bio;
        private String role;
        private Integer status;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
    }

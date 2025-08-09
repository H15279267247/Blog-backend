package com.zhieasy.VO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserProfileVO {  //用户详细资料返回对象
    private Integer id;
    private String phone;
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDate birthday;
    private String location;
    private String bio;
    private String role;
    private Integer status;
}

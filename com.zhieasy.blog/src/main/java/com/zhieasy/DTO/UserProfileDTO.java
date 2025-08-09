package com.zhieasy.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserProfileDTO {//用户资料更新请求参数
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDate birthday;
    private String location;
    private String bio;
}

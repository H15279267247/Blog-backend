package com.zhieasy.VO;

import lombok.Data;

@Data
public class UserInfoVO {  //用户信息返回对象
    private Integer id;
    private String phone;
    private String nickname;
    private String avatar;
    private String role;
    private Integer status;
}


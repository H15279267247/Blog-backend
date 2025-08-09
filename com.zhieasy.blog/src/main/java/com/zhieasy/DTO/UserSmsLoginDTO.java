package com.zhieasy.DTO;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserSmsLoginDTO {   //短信登录请求参数
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    private String smsCode;
}


package com.zhieasy.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private T data;
    private String message;

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, data, message);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(200, null, message);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, null, message);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(400, null, message);
    }
}

package com.this0.headline.util;

/**
 * 统一返回结果状态信息类
 *
 */
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    LOGIN_ERROR(501,"usernameErrororPasswdError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}


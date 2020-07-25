package com.code.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 枚举了一些常用API操作码
 *
 * @author zlh-dev
 * @date 2020/05/23 14:35
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(true, 20000, "操作成功"),
    /**
     * 失败
     */
    UNKNOWN_ERROR(false, 21000, "未知异常"),

    /**
     * 空指针
     */
    NULL_POINT(false, 21001, "空指针异常"),

    /**
     * http客户端错误
     */
    HTTP_CLIENT_ERROR(false, 21002, "http客户端异常"),

    /**
     * 验证失败
     */
    VALIDATE_FAILED(false, 21003, "参数检验失败"),

    /**
     * 未经授权
     */
    UNAUTHORIZED(false, 21004, "暂未登录或token已经过期"),

    /**
     * 禁止
     */
    FORBIDDEN(false, 21005, "没有相关权限");

    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

}

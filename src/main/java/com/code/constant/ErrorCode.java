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
public enum ErrorCode {

    /**
     * 正确执行后的返回
     */
    SUCCESS("00000", "一切 ok"),

    USER_ERROR("A0001", "用户端错误"),
    USER_REGISTER_ERROR("A0100", "用户注册错误"),
    USER_LOGIN_ERROR("A0200", "用户登录异常"),
    USER_AUTHORITY_ERROR("A0300", "访问权限异常"),
    USER_REQUEST_PARAM_ERROR("A0400", "用户请求参数错误"),
    USER_REQUEST_SERVICE_ERROR("A0500", "用户请求服务异常"),
    USER_RESOURCE_ERROR("A0600", "用户资源异常"),
    USER_UPLOAD_ERROR("A0700", "用户上传文件异常"),

    SYSTEM_ERROR("B0001", "系统执行出错"),
    SYSTEM_TIMEOUT_ERROR("B0100", "系统执行超时"),
    SYSTEM_RESOURCE_ERROR("B0300", "系统资源异常"),

    OTHER_ERROR("C0001", "调用第三方服务出错"),
    CACHE_ERROR("C0130", "缓存服务出错"),
    OTHER_TIMEOUT_ERROR("C0200", "第三方系统执行超时"),
    DATABASE_ERROR("C0300", "数据库服务出错"),

    HTTP_CLIENT_ERROR("D0001", "http客户端异常"),

    UNKNOWN_ERROR("E0000", "其他异常");

    /**
     * 响应状态码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;

}

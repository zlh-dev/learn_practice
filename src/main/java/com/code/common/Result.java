package com.code.common;

import com.code.constant.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 通用返回对象
 *
 * @author zlh-dev
 * @date 2020/05/23 14:32
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {


    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 相应消息
     */
    private String message;
    /**
     * 携带数据
     */
    private T data;

    /**
     * 成功返回结果
     *
     * @return {@link Result<T>}
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @return {@link Result <T>}
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed() {
        return failed(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * 失败返回结果
     *
     * @param resultCode 错误信息
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed(ResultCode resultCode) {
        return new Result<>(false, resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 错误信息
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed(String message) {
        return new Result<T>(false, ResultCode.UNKNOWN_ERROR.getCode(), message, null);
    }

}
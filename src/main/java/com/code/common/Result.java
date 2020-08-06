package com.code.common;

import com.code.constant.ErrorCode;
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
    private String code;
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
        return new Result<>(true, ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed() {
        return failed(ErrorCode.UNKNOWN_ERROR);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误信息
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed(ErrorCode errorCode) {
        return new Result<>(false, errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 错误信息
     * @return {@link Result <T>}
     */
    public static <T> Result<T> failed(String message) {
        return new Result<>(false, ErrorCode.UNKNOWN_ERROR.getCode(), message, null);
    }

}
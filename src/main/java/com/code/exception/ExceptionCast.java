package com.code.exception;

import com.code.constant.ResultCode;

/**
 * 异常转化
 *
 * @author zlh-dev
 * @date 2020/07/05 11:19:35
 */
public class ExceptionCast {

    /**
     * 静态方法 抛出异常
     *
     * @param resultCode 结果代码
     */
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
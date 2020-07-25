package com.code.exception;

import com.code.common.Result;
import com.code.constant.ResultCode;
import com.code.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 统一异常处理器
 *
 * @author zlh-dev
 * @date 2020/07/05 11:04:52
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 通用异常处理方法
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        // 通用异常结果
        return Result.failed(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * -------- 指定异常处理方法 --------
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.failed(ResultCode.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.failed(ResultCode.HTTP_CLIENT_ERROR);
    }

    /**
     * 捕获CustomException类异常
     *
     * @param customException 自定义异常
     * @return 结果信息, json数据
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customException(CustomException customException) {
        // 记录日志
        log.error(ExceptionUtil.getMessage(customException));
        ResultCode resultCode = customException.getResultCode();
        return Result.failed(resultCode);
    }
}

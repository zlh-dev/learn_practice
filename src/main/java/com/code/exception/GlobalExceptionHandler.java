package com.code.exception;

import com.code.common.Result;
import com.code.constant.ErrorCode;
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
    public Result<Object> error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        // 通用异常结果
        return Result.failed(ErrorCode.UNKNOWN_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result<Object> error(IndexOutOfBoundsException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.failed(ErrorCode.HTTP_CLIENT_ERROR);
    }

    /**
     * 捕获CustomException类异常
     *
     * @param customException 自定义异常
     * @return 结果信息, json数据
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<Object> customException(CustomException customException) {
        // 记录日志
        log.error(ExceptionUtil.getMessage(customException));
        var errorCode = customException.getErrorCode();
        return Result.failed(errorCode);
    }
}

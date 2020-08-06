package com.code.exception;

import com.code.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义全局异常类
 *
 * @author zlh-dev
 * @date 2020/07/05 11:03:41
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;

}
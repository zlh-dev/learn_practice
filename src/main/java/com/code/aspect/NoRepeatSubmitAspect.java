package com.code.aspect;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.code.annotation.NoRepeatSubmit;
import com.code.common.Result;
import com.code.util.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 防止重复提交切面
 *
 * @author zlh_dev
 * @date 2020/08/03
 */
@Aspect
@Component
public class NoRepeatSubmitAspect {

    private static final Log LOG = LogFactory.get();

    @Autowired
    private RedisUtils redisUtils;

    @Around("execution(* com.code.controller.*Controller.*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            // 如果缓存中有这个url视为重复提交
            if (redisUtils.hasKey(key)) {
                Object o = pjp.proceed();
                redisUtils.set(key, 0, 2);
                return o;
            } else {
                LOG.warn("重复提交");
                return null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            LOG.error("验证重复提交时出现未知异常!");
            return Result.failed("验证重复提交时出现未知异常!");
        }

    }

}
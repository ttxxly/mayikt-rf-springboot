package com.mayikt.service.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.mayikt.service.annotation.MayiktCurrentLimit;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 余胜军
 * @ClassName ExtTransactionalAop
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Aspect
@Component
public class CurrentLimitAop {
    /**
     * 每秒生成1.0个令牌
     * //
     */

    private ConcurrentHashMap<String, RateLimiter> rateLimiters = new ConcurrentHashMap<>();
    /**
     * 前置
     *
     */

    /**
     * @param joinPoint
     * @return
     * @Around(value = "@annotation(com.mayikt.service.annotation.MayiktCurrentLimit)")
     * 只要使用MayiktCurrentLimit注解就会被拦截。
     */
    @Around(value = "@annotation(com.mayikt.service.annotation.MayiktCurrentLimit)")
    public Object around(ProceedingJoinPoint joinPoint) {
        // 走该环绕通知
        try {
            //获取拦截的方法名
            Signature sig = joinPoint.getSignature();
            //获取拦截的方法名
            MethodSignature methodSignature = (MethodSignature) sig;
            MayiktCurrentLimit mayiktCurrentLimit = methodSignature.getMethod().getDeclaredAnnotation(MayiktCurrentLimit.class);
            // 获取到该注解的name
            String name = mayiktCurrentLimit.name();
            // 获取该注解的token
            double token = mayiktCurrentLimit.token();
            // 判断该名称是否有创建RateLimiter
            RateLimiter rateLimiter = rateLimiters.get(name);
            if (rateLimiter == null) {
                rateLimiter = RateLimiter.create(token);
                rateLimiters.put(name, rateLimiter);
            }
            /**
             * 如果被限流的话
             */
            boolean result = rateLimiter.tryAcquire();
            if (!result) {
                return "当前访问人数过多，请稍后重试!";
            }
            Object proceedResult = joinPoint.proceed();// 目标方法   public String get() {}
            return proceedResult;
        } catch (Throwable throwable) {
            return "系统错误!";
        }

    }
    /**
     * 回顾：
     * 环绕通知 目标方法的前后做操作
     * 1.
     */
}
package com.mayikt.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 余胜军
 * @ClassName MayiktCurrentLimit
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MayiktCurrentLimit {
    /**
     * name 限流的名称
     *
     * @return
     */
    String name() default "";

    /**
     * 每s 能够允许访问的次数 20 底层
     * 令牌桶
     *
     * @return
     */
    double token() default 20;

}

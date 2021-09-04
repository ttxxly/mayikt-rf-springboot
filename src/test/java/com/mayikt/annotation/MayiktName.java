package com.mayikt.annotation;

import java.lang.annotation.*;

/**
 * @author 余胜军
 * @ClassName MayiktName
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MayiktName {
}

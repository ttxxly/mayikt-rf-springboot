package com.mayikt.test;

import com.mayikt.annotation.MayiktName;

import java.lang.reflect.Method;

/**
 * @author 余胜军
 * @ClassName Test06
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> userClass = Class.forName("com.mayikt.entity.UserEntity");
        Object o = userClass.newInstance();
        Method mayiktMethod = userClass.getDeclaredMethod("mayikt");
        MayiktName mayiktName = mayiktMethod.getDeclaredAnnotation(MayiktName.class);
        System.out.println(mayiktName);
    }
}

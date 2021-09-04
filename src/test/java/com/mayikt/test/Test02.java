package com.mayikt.test;

import com.mayikt.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 余胜军
 * @ClassName Test02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test02 {
    /**
     * 有参
     * 无参
     * 构造函数
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> userClass2 = Class.forName("com.mayikt.entity.UserEntity");
        /**
         * 默认执行无参构造函数
         */
//        UserEntity userEntity1 = (UserEntity) userClass2.newInstance();
//        System.out.println(userEntity1);
        Constructor<?> declaredConstructor = userClass2.getDeclaredConstructor(String.class, Integer.class);
        UserEntity userEntity2 = (UserEntity) declaredConstructor.newInstance("mayikt", 22);
        System.out.println(userEntity2.toString());
    }
}

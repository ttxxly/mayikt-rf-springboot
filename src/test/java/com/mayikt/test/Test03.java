package com.mayikt.test;

import com.mayikt.entity.UserEntity;

import java.lang.reflect.Field;

/**
 * @author 余胜军
 * @ClassName Test03
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> userClass = Class.forName("com.mayikt.entity.UserEntity");
        UserEntity userEntity1 = (UserEntity) userClass.newInstance();
        // 查找到属性
        Field pubUserName = userClass.getDeclaredField("userName");
        // 反射访问私有属性
        pubUserName.setAccessible(true);
        pubUserName.set(userEntity1, "mayikt");
        System.out.println(userEntity1.getUserName());
//        Field[] fields = userClass.getDeclaredFields();
//        for (Field field :
//                fields) {
//            System.out.println(field);
//        }
    }
}

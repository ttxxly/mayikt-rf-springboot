package com.mayikt.test;

import com.mayikt.entity.UserEntity;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 反射机制 动态 获取class 信息内容 类的名称 方法 属性
        /**
         * UserEntity.java 源代码 编译UserEntity.class
         */
        /**
         * 1.获取class UserEntity.class
         * 2.Class.forName("");
         */
        Class userClass1 = UserEntity.class;
        // 2.默认执行无参构造函数
        UserEntity userEntity1 = (UserEntity) userClass1.newInstance();
        System.out.println(userEntity1);
        /**
         * 类的完整路径地址 包名+类名
         */
        Class<?> userClass2 = Class.forName("com.mayikt.entity.UserEntity");
        System.out.println(userClass1 == userClass2);
        // 3.new UserEntity().getClass()
       /* UserEntity userEntity2 = new UserEntity();
        System.out.println(userEntity1.equals(userEntity2));*/
        Class userClass3 = userEntity1.getClass();
        System.out.println(userClass1==userClass3);

    }
}

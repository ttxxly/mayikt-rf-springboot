package com.mayikt.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 余胜军
 * @ClassName Test04
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> userClass = Class.forName("com.mayikt.entity.UserEntity");
        Object o = userClass.newInstance();
        Method sumMethod = userClass.getDeclaredMethod("sum", Integer.class, Integer.class);
        sumMethod.setAccessible(true);
        Integer result = (Integer) sumMethod.invoke(o, 1, 2);
        System.out.println(result);
//        Method method = userClass.getDeclaredMethod("mayikt");
//        method.setAccessible(true);
//        Object invoke = method.invoke(o);
//        Method[] methods = userClass.getMethods();
//        for (Method method:
//                methods) {
//            System.out.println(method);
//        }
    }
}

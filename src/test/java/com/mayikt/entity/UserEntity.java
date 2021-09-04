package com.mayikt.entity;


import com.mayikt.annotation.MayiktName;

/**
 * @author 余胜军
 * @ClassName UserEntity
 * @qq 644064779
 * @addres www.mayikt.com
 */
public class UserEntity {
    private String userName;
    private Integer userAge;

    public String pubUserName;


    public UserEntity(String userName, Integer userAge) {
        System.out.println("执行有参构造函数userName:" + userName + "," + userAge);
        this.userName = userName;
        this.userAge = userAge;
    }

    public UserEntity() {
        System.out.println("无参构造函数...");
    }

    @Deprecated
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
//    @MayiktName
    public void mayikt() {
        System.out.println(" ...mayikt.....");
    }


    private Integer sum(Integer a, Integer b) {
        return a + b;
    }
}


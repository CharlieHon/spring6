package com.charlie.spring6.bean;

/**
 * 这是一个bean，封装了用户的信息
 * @author: charlie
 * @date: Created in 2024/11/1 13:57
 * @description: User
 */
public class User {
    // Spring是如何实例化对象？
    // 默认情况下Spring会通过反射机制，调用类的无参构造方法来实例化对象
    // 实现原理如下
    /*
    Class clazz = Class.forName("com.charlie.spring6.bean.User");
    Object obj = clazz.newInstance();
     */
    public User() {
        System.out.println("User的无参构造方法执行...");
    }

    public User(String name) {
        System.out.println("User(String name) 构造方法执行...");
    }
}

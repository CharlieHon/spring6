package com.charlie.spring6.dao.impl;

import com.charlie.spring6.dao.UserDao;

/**
 * @author: charlie
 * @date: Created in 2024/11/1 11:34
 * @description: UserDAOImpl
 */
public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Mysql数据库正在删除用户信息");
    }
}

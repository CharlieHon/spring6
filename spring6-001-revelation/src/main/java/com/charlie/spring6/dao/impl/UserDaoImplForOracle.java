package com.charlie.spring6.dao.impl;

import com.charlie.spring6.dao.UserDao;

/**
 * @author: charlie
 * @date: Created in 2024/11/1 11:41
 * @description: UserDaoImplForOracle
 */
public class UserDaoImplForOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle数据库正在删除用户信息");
    }
}

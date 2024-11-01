package com.charlie.spring6.service.impl;

import com.charlie.spring6.dao.UserDao;
import com.charlie.spring6.dao.impl.UserDaoImplForMySQL;
import com.charlie.spring6.dao.impl.UserDaoImplForOracle;
import com.charlie.spring6.service.UserService;

/**
 * @author: charlie
 * @date: Created in 2024/11/1 11:35
 * @description: UserServiceImpl
 */
public class UserServiceImpl implements UserService {

    // service层依赖dao层的具体实现，当需要访问oracle等其它数据库时，需要修改该部分代码
   // private UserDao userDao = new UserDaoImplForMySQL();
   //  private UserDao userDao = new UserDaoImplForOracle();

    private UserDao userDao;

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }

}

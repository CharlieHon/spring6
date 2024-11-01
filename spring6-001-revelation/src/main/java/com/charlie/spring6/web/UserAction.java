package com.charlie.spring6.web;

import com.charlie.spring6.service.UserService;
import com.charlie.spring6.service.impl.UserServiceImpl;

/**
 * 表示层
 * @author: charlie
 * @date: Created in 2024/11/1 11:33
 * @description: UserAction
 */
public class UserAction {
    // private UserService userService = new UserServiceImpl();

    private UserService userService;

    /**
     * 删除用户信息的请求
     */
    public void deleteRequest() {
        userService.deleteUser();
    }
}

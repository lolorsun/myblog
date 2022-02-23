package com.lolorsun.myblog.service;

import com.lolorsun.myblog.po.User;

/**
 * @Author lolorsun
 * @Date 2022/2/20 21:31
 * @Version 1.0
 */
public interface UserService {
    User checkUser(String usename,String password);
}

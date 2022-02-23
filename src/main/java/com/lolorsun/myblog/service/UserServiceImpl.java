package com.lolorsun.myblog.service;

import com.lolorsun.myblog.dao.UserRepository;
import com.lolorsun.myblog.po.User;
import com.lolorsun.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lolorsun
 * @Date 2022/2/20 21:33
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username,String password){
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}

package com.lolorsun.myblog.dao;

import com.lolorsun.myblog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lolorsun
 * @Date 2022/2/20 21:36
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}

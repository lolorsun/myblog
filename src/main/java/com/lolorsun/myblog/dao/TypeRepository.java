package com.lolorsun.myblog.dao;

import com.lolorsun.myblog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lolorsun
 * @Date 2022/2/23 20:32
 * @Version 1.0
 */
public interface TypeRepository extends JpaRepository<Type,Long> {
}

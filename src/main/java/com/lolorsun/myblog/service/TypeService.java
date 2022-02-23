package com.lolorsun.myblog.service;
import com.lolorsun.myblog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author lolorsun
 * @Date 2022/2/23 20:23
 * @Version 1.0
 */

public interface TypeService {
    //增加
    public Type saveType(Type type);
    //删除
    public void delType(Long id);
    //修改
    public Type updateType(Long id,Type type);
    //查询
    public Type getOneType(Long id);
    public Page<Type> getTypes(Pageable pageable);

}

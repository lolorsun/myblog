package com.lolorsun.myblog.service;

import com.lolorsun.myblog.NotFoundException;
import com.lolorsun.myblog.dao.TypeRepository;
import com.lolorsun.myblog.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lolorsun
 * @Date 2022/2/23 20:28
 * @Version 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;
    @Transactional//事务
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }
    @Transactional
    @Override
    public void delType(Long id) {
        typeRepository.delete(id);
    }
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findOne(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }
    @Transactional
    @Override
    public Type getOneType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Page<Type> getTypes(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }


}

package com.example.demo.service;

import com.example.demo.entity.vue_user;
import com.example.demo.mapper.vue_user_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private vue_user_mapper userMapper;
    public  int save(vue_user user){
        if(user.getId()==null){
         return   userMapper.insert(user);
        }else {
         return   userMapper.update(user);
        }
    }
}

package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.vue_user;
import com.example.demo.mapper.vue_user_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService  extends ServiceImpl<vue_user_mapper,vue_user>{
    //用mybatis plus 改写
    public Boolean saveUser(vue_user user) {

//可以将下面的代码简化
                if(user.getId()==null){
          //serviceimpl中提供的save方法，表示插入数据
            return save(user);
        }
        else {
            return updateById(user);
        }
// 报错error: can not execute. because can not find cache of TableInfo for entity! 此处使用这个函数有问题     return saveOrUpdate(user);
    }


    //原先的save函数
//    @Autowired
//    private vue_user_mapper userMapper;
//  public  int save(vue_user user){
//        if(user.getId()==null){
//         return   userMapper.insert(user);
//        }else {
//         return   userMapper.update(user);
//        }
//    }
}

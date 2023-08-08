package com.example.demo.mapper;

import com.example.demo.entity.vue_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface vue_user_mapper {
    @Select("SELECT * FROM vue_user")
    List<vue_user> findAll();

    @Insert("INSERT INTO vue_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password},"+
            "#{nickname},#{email},#{phone},#{address});")
    Integer insert(vue_user user);
}

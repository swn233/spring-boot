package com.example.demo.mapper;

import com.example.demo.entity.vue_user;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface vue_user_mapper {
    @Select("SELECT * FROM vue_user")
    List<vue_user> findAll();



    @Insert("INSERT INTO vue_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password},"+
            "#{nickname},#{email},#{phone},#{address});")
    Integer insert(vue_user user);

    //@Update("update vue_user set username=#{username},password=#{password},nickname=#{nickname},email=#{email},"+
    //      "phone=#{phone},address=#{address} where id =#{id}")
    int update(vue_user user);

    @Delete("DELETE  FROM  vue_user WHERE  id =#{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM  vue_user LIMIT #{pageNum},#{pageSize}")
    List<vue_user> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT COUNT(*) FROM vue_user")
    Integer selectTotal();
}

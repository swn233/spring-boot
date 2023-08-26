package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vue_user;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Mapper
public interface vue_user_mapper extends BaseMapper<vue_user> {
    @Select("SELECT * FROM vue_user")
    List<vue_user> findAll();

    @Insert("INSERT INTO vue_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password},"+
            "#{nickname},#{email},#{phone},#{address});")
    int insert(vue_user user);

//    @Update("update vue_user set username=#{username},password=#{password},nickname=#{nickname},email=#{email},"+
//          "phone=#{phone},address=#{address} where id =#{id}")
    int updateById(vue_user user);

    @Delete("DELETE  FROM  vue_user WHERE  id =#{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM  vue_user WHERE username like concat('%',#{username},'%') LIMIT #{pageNum},#{pageSize}")
    List<vue_user> selectPage(Integer pageNum, Integer pageSize, String username);

    @Select("SELECT COUNT(*) FROM vue_user WHERE username like concat('%',#{username},'%')  ")
    Integer selectTotal(String username);
}

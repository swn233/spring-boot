package com.example.demo.controller;

import com.example.demo.entity.vue_user;
import com.example.demo.mapper.vue_user_mapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserControllor {
    @Autowired
    private vue_user_mapper userMapper;
    @Autowired
    private UserService userService;


    @PostMapping
    public boolean save(@RequestBody vue_user user){
        //新增或者更新
        return userService.saveUser(user);
    }
    //查询所有结果
    @GetMapping("/")
    public List<vue_user> index(){
        new vue_user();
        return userMapper.findAll();
        //mybatis plus 方法
        //return userService.list();测试接口失败，错误码500
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    //分页查询
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam  Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username){
        pageNum=(pageNum-1)*pageSize;
        List<vue_user> data = userMapper.selectPage(pageNum, pageSize,username);
        Integer total= userMapper.selectTotal(username);
        Map<String,Object>res =new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}

package com.example.demo;

import com.example.demo.entity.vue_user;
import com.example.demo.mapper.vue_user_mapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@SpringBootApplication
public class Demo1Application {
    @Autowired
    private vue_user_mapper userMapper;
    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @PostMapping
    public Integer save(@RequestBody vue_user user){
     //新增或者更新
        return userService.save(user);
    }
    //查询所有结果
    @GetMapping("/")
    public List<vue_user> index(){
        new vue_user();
        return userMapper.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }


    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam  Integer pageNum,@RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<vue_user> data = userMapper.selectPage(pageNum, pageSize);
       Integer total= userMapper.selectTotal();
        Map<String,Object>res =new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}

package com.example.demo;

import com.example.demo.entity.vue_user;
import com.example.demo.mapper.vue_user_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@SpringBootApplication
public class Demo1Application {
    @Autowired
    private vue_user_mapper userMapper;
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @PostMapping
    public Integer save(){
        return userMapper.insert();
    }
    @GetMapping("/")
    public List<vue_user> index(){
        new vue_user();
        return userMapper.findAll();
    }


}

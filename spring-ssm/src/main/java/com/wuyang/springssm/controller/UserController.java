package com.wuyang.springssm.controller;

import com.wuyang.springssm.bean.Tuser;
import com.wuyang.springssm.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Resource
  UserMapper userMapper;

  @GetMapping("/user/{id}")
  public Tuser getUser(@PathVariable("id") Long id) {
    Tuser user = userMapper.getUserById(1L);
    return user;
  }
}

package com.wuyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody//标注返回json的纯文本数据的
//@Controller
@RestController//前两个注解的合体
public class HelloController {
  @Autowired
  StringRedisTemplate redisTemplate;

  @GetMapping("/hello")
  public String hello() {
    return "Hello Spring Boot 3!";
  }


  @GetMapping("/count")
  public String count() {
    Long haha = redisTemplate.opsForValue().increment("haha");
    return "增加后的值"+haha;
  }
}

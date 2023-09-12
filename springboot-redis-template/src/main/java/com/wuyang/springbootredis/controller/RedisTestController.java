package com.wuyang.springbootredis.controller;

import com.wuyang.springbootredis.entity.Person;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
  @Autowired
  StringRedisTemplate stringRedisTemplate;
  //如果给redis中保存数据会使用默认的序列化机制，导致redis中保存的对象不可视，所有对象都是以json的方式保存
  @Autowired
  RedisTemplate<Object, Object> redisTemplate;

  @GetMapping("/count")
  public String count() {
    Long hello = stringRedisTemplate.opsForValue().increment("hello");
    //常见的数据类型 k v  value可以有很多类型
    //string: 普通字符串  stringRedisTemplate.opsForValue()
    //list: 列表          stringRedisTemplate.opsForList()
    //set: 集合           stringRedisTemplate.opsForSet()
    //zset: 有序集合       stringRedisTemplate.opsForZSet()
    //hash: map结构        stringRedisTemplate.opsForHash()

    return "已经访问了"+hello+"次";
  }
  @GetMapping("/person/save")
  public String savePerson() {

    Person person = new Person(2l, "小狐", 18, new Date());
    redisTemplate.opsForValue().set("person",person);
    return "ok";
  }
  @GetMapping("/person/get")
  public Person getPerson() {
    Person person = (Person) redisTemplate.opsForValue().get("person");
    return person;
  }
}

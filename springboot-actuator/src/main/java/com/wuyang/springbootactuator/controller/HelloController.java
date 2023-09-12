package com.wuyang.springbootactuator.controller;

import com.wuyang.springbootactuator.component.MyHealthComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @Autowired
  MyHealthComponent myHealthComponent;

  @GetMapping("/hello")
  public String hello() {
    //业务调用
    myHealthComponent.hello();
    return "哈哈哈";
  }
}

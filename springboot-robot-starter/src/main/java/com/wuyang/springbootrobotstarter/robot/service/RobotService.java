package com.wuyang.springbootrobotstarter.robot.service;

import com.wuyang.springbootrobotstarter.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

  @Autowired
  RobotProperties robotProperties;

  public String sayHello() {
    return "你好：名字【"+robotProperties.getName()+"】，年龄【"+robotProperties.getAge()+"】，邮箱【"+ robotProperties.getEmail()+"】";
  }
}

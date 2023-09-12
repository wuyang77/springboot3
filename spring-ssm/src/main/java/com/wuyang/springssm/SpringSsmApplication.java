package com.wuyang.springssm;

import com.wuyang.springbootrobotstarter.robot.annotation.EnableRobot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//告诉mybatis哪个包下的所有接口
@MapperScan(basePackages = "com.wuyang.springssm.mapper")
@EnableRobot
@SpringBootApplication
public class SpringSsmApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSsmApplication.class, args);
  }

}

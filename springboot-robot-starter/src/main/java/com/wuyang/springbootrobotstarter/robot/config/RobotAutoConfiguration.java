package com.wuyang.springbootrobotstarter.robot.config;

import com.wuyang.springbootrobotstarter.robot.controller.RobotController;
import com.wuyang.springbootrobotstarter.robot.properties.RobotProperties;
import com.wuyang.springbootrobotstarter.robot.service.RobotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//给容器中导入Robot功能要用的所有组件
@Import({RobotService.class, RobotProperties.class})
@Configuration
public class RobotAutoConfiguration {

  @Bean
  public RobotController robotController() {
    return new RobotController();
  }
}


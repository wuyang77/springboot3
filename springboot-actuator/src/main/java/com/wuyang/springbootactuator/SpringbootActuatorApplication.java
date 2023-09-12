package com.wuyang.springbootactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 整合Prometheus+Grafana
 * 1.改造SpringBoot应用，产生Prometheus所需要的格式数据
 * 2.部署java应用。在同一个机器内，访问私网ip:9527/actuator/prometheus就能得到指标数据
 * 在外面访问公网ip:9527/actuator/prometheus
 * 3.修改prometheus配置文件，让他拉取某个应用的指标数据
 * 4.去grafana添加一个prometheus数据源，配置好prometheus地址
 */
@SpringBootApplication
public class SpringbootActuatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootActuatorApplication.class, args);
  }

}

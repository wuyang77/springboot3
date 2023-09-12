package com.wuyang.springbootfeatures;

import com.wuyang.springbootrobotstarter.robot.annotation.EnableRobot;
import com.wuyang.springbootrobotstarter.robot.config.RobotAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc//全面接管SpringMVC,禁用所有SpringNVC的自动配置
//@EnableAsync//开启异步
@EnableScheduling//开启定时任务
@SpringBootApplication
//@ComponentScan(basePackages = "com.wuyang.springbootrobotstarter.robot")//直接开启扫描
//@Import(RobotAutoConfiguration.class)一层抽取
@EnableRobot//二层抽取
@Slf4j
public class SpringbootFeaturesApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringbootFeaturesApplication.class, args);
    //1.自定义SpringApplication的底层行为
//    SpringApplication application = new SpringApplication();
    //程序化调整底层参数，配置行为
//    application.setBannerMode(Mode.CONSOLE);
//    2.让SpringApplication运行起来
//    application.run(args);

    //fluetAPI
    new SpringApplicationBuilder()
        .main(SpringApplication.class)
        .bannerMode(Mode.CONSOLE)
        .sources((SpringbootFeaturesApplication.class))
//        .environment(null)
//        .listeners(null)
        .run(args);
  }

}

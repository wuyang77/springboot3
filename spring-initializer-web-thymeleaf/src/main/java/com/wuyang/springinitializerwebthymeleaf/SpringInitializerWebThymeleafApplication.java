package com.wuyang.springinitializerwebthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//@SpringBootApplication(scanBasePackages = {"com.wuyang"})
//@ComponentScan("com.wuyang")

@SpringBootApplication
public class SpringInitializerWebThymeleafApplication {

  public static void main(String[] args) {
    //JDK10 局部量的自动推断
    var ioc = SpringApplication.run(SpringInitializerWebThymeleafApplication.class, args);
    //1.获取容器中所有组件的名字
    //2.遍历
//    for (String name : ioc.getBeanDefinitionNames()) {
//      System.out.println(name);
//    }
  }
/**
 *1.自动配置Tomcat、SpringMVC
 *  - 导入web开发场景就会自动配置好这个场景的核心组件
 *  - 以前：DispatcherServlet,ViewResolver,CharacterEncoding
 *  - 现在：自动配置好这些组件
 *  - 验证：容器中有什么组件，就具有什么功能
 *
 *2.默认的包扫描规则
 *  - @SpringBootApplication标注的类为主启动类
 *  - 只会扫描主启动类所在包及其子包com.wuyang.springinitializerwebthymeleaf.*
 *
 *3.自定义扫描路径
 *  - @SpringBootApplication(scanBasePackages = {"com.wuyang"})
 *  - @ComponentScan("com.wuyang")
 *
 * 4.默认配置值
 *  - 配置文件的所以配置项是和某一个对象类的值一一绑定的
 *  - 绑定了配置文件中的每一项值的类：配置属性类
 *    - ServerProperties:绑定了Tomcat服务器有关的配置
 *    - MultipartProperties：绑定了与文件上传有关的所有配置
 *    - 参照官方文档：https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties
 *  5.按需加载的自动配置
 *    - 导入场景 spring-boot-starter-web
 *    - 继承 spring-boot-starter 基础核心，是所有starter的starter
 *    - spring-boot-starter里头又有spring-boot-autoconfigure ，包含了所有场景的Autoconfigure自动配置类
 *    - 岁让全场景的自动配置都在spring-boot-autoconfigure这个包，但是不是全部开启的
 *      导入哪个场景就开启哪个配置
 */
}

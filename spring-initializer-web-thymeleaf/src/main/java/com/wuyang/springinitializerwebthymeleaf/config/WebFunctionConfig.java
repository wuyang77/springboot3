package com.wuyang.springinitializerwebthymeleaf.config;

import com.wuyang.springinitializerwebthymeleaf.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class WebFunctionConfig {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(UserBizHandler userHandler/*这个会被自动注入进来*/) {
    return RouterFunctions.route()//开始定义路由信息
        .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL), userHandler:: getUser)
        .GET("/users", userHandler:: getUsers)
        .POST("/user", RequestPredicates.accept(MediaType.ALL), userHandler:: createUser)
        .PUT("/user/{id}", RequestPredicates.accept(MediaType.ALL), userHandler:: updateUser)
        .DELETE("/user/{id}", userHandler:: deleteUser)
        .build();
  }
  //  @Bean
  //  public RouterFunction<ServerResponse> groupRoute(UserBizHandler userHandler/*这个会被自动注入进来*/) {
  //    return RouterFunctions.route()//开始定义路由信息
  //        .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL)
  //        .and(RequestPredicates.param("aa","bb")),
  //            userHandler :: getUser)
  //        .GET("/users",userHandler :: getUsers)
  //        .POST("/user", RequestPredicates.accept(MediaType.ALL), userHandler :: createUser)
  //        .PUT("/user/{id}", RequestPredicates.accept(MediaType.ALL), userHandler :: updateUser)
  //        .DELETE("/user/{id}", userHandler :: deleteUser)
  //        .build();
  //  }
}

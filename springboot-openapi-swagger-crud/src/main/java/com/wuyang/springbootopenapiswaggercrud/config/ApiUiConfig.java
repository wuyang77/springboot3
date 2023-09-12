package com.wuyang.springbootopenapiswaggercrud.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.configuration.Knife4jAutoConfiguration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiUiConfig {
//  @Bean
//  public Docket publicApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("org.github.springshop.web.public"))
//        .paths(PathSelectors.regex("/public.*"))
//        .build()
//        .groupName("springshop-public")
//        .apiInfo(apiInfo());
//  }
//
//  @Bean
//  public Docket adminApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("org.github.springshop.web.admin"))
//        .paths(PathSelectors.regex("/admin.*"))
//        .apis(RequestHandlerSelectors.withMethodAnnotation(Admin.class))
//        .build()
//        .groupName("springshop-admin")
//        .apiInfo(apiInfo());
//  }

  /**
   * 分组设置（Docket配置）
   * @return
   */
  @Bean
  public GroupedOpenApi employeeApi() {
    return GroupedOpenApi.builder()
        .group("员工管理")
        .pathsToMatch("/employee/**", "/employees")
        .build();
  }
  @Bean
  public GroupedOpenApi deptApi() {
    return GroupedOpenApi.builder()
        .group("部门管理")
        .pathsToMatch("/dept/**","/depts")
//        .addMethodFilter(method -> method.isAnnotationPresent(Dept.class))
        .build();
  }
  @Bean
  public GroupedOpenApi bodyApi() {
    return GroupedOpenApi.builder()
        .group("主体")
        .pathsToMatch("/body/**")
//        .addMethodFilter(method -> method.isAnnotationPresent(Dept.class))
        .build();
  }

  /**
   * OpenAPI配置
   * @return
   */
  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("SpringBoot3 API")
            .description("专门测试接口文件")
            .version("v0.0.1")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("SpringShop Wiki Documentation")
            .url("https://springshop.wiki.github.org/docs"));
  }

}

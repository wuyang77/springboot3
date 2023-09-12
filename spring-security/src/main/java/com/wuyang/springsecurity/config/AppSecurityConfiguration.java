package com.wuyang.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 1.自定义请求授权规则：http.authorizeHttpRequests
 * 2.自定义登录规则：http.formLogin
 * 3.自定用户信息查询规则：UserDetailsService
 * 4.开启方法级别的精确权限控制：@EnableMethodSecurity+
 */
@EnableMethodSecurity
@Configuration
public class AppSecurityConfiguration {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(registry -> {
      registry.requestMatchers("/")
          .permitAll()//首页所有人都可以访问
          .anyRequest().authenticated();//剩下的所有请求都需要认证登录
    });
    //自定义表单
    http.formLogin(formLogin -> {
      formLogin.loginPage("/login").permitAll();//自定义登录页,并且所有人都能访问
    });
    return http.build();
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  UserDetailsService userDetailsService (PasswordEncoder passwordEncoder) {
    UserDetails wuyang = User.withUsername("wuyang")
        .password(passwordEncoder.encode("1234"))
        .roles("admin", "hr")
        .authorities("file_read", "file_write")
        .build();
    UserDetails lisi = User.withUsername("lisi")
        .password(passwordEncoder.encode("1234"))
        .roles("hr")
        .authorities("file_write")
        .build();
    UserDetails zhangsan = User.withUsername("zhangsan")
        .password(passwordEncoder.encode("1234"))
        .roles("admin")
        .authorities("file_read","world_exec")
        .build();
    //模拟内存中保留信息
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(wuyang,lisi,zhangsan);
    return manager;
  }
}

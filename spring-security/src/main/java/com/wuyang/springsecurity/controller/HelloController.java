package com.wuyang.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello() {
    return "hello,wuyang";
  }
  @PreAuthorize("hasAuthority('world_exec')")
  @GetMapping("/world")
  public String world() {
    return "hello,Spring Security";
  }
}

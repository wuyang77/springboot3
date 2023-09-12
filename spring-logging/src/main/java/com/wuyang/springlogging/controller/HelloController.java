package com.wuyang.springlogging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloController {
  @GetMapping("/h")
  public String hello() {

    for (int i = 0;i < 1000; i++) {
      log.trace("trace.....");
      log.debug("debug.....");
//    Logger logger = LoggerFactory.getLogger(getClass());
      //springboot底层默认的日志级别info
      log.info("info.....");
      log.warn("warn.....");
      log.error("errpr.....");
    }
//    logger.info("哈哈哈哈，方法进来了");
    return "Hello World!";
  }
}

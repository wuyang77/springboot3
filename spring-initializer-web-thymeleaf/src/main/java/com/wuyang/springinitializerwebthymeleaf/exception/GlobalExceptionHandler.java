package com.wuyang.springinitializerwebthymeleaf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@ControllerAdvice//集中处理系统的异常
//@RestControllerAdvice
public class GlobalExceptionHandler {

/*  @ResponseBody
  @ExceptionHandler(Exception.class)*/
  public String handleException(Exception ex) {
    return "哦豁~~~~统一异常处理"+ex.getMessage();
  }

}
